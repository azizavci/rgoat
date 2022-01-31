package com.rzk.RitzyGoat.api.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rzk.RitzyGoat.core.utilities.security.springSecurity.payload.request.LoginRequest;
import com.rzk.RitzyGoat.core.utilities.security.springSecurity.payload.request.SignupRequest;
import com.rzk.RitzyGoat.core.utilities.security.springSecurity.payload.response.JwtResponse;
import com.rzk.RitzyGoat.core.utilities.security.springSecurity.payload.response.MessageResponse;
import com.rzk.RitzyGoat.core.utilities.security.springSecurity.services.UserDetailsImpl;
import com.rzk.RitzyGoat.core.utilities.security.springVerification.user.service.DefaultUserService;
import com.rzk.RitzyGoat.entities.concretes.Customer;
import com.rzk.RitzyGoat.entities.concretes.ERole;
import com.rzk.RitzyGoat.entities.concretes.Role;
import com.rzk.RitzyGoat.entities.concretes.User;

import com.rzk.RitzyGoat.dataAccess.abstracts.UserDao;
import com.rzk.RitzyGoat.dataAccess.abstracts.RoleDao;
import com.rzk.RitzyGoat.core.utilities.security.springSecurity.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DefaultUserService defaultUserService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserDao userRepository;

	@Autowired
	RoleDao roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		User user = userDao.findByEmail(loginRequest.getEmail())
				.orElseThrow(() -> new RuntimeException("Error: User is not found."));

		// if (user.isVerified()) {
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail(), roles));
		//}

		//return ResponseEntity.badRequest().body(new MessageResponse("Please check your email for verification!"));

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		// if (userRepository.existsByUsername(signUpRequest.getUsername())) {
		// return ResponseEntity.badRequest().body(new MessageResponse("Error: Username
		// is already taken!"));
		// }

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		Customer user = new Customer(signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		defaultUserService.register(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@GetMapping("/verify")
	public ResponseEntity<?> verifyUser(@RequestParam(required = false) String token, RedirectAttributes redirAttr) {

		if (StringUtils.isEmpty(token)) {
			redirAttr.addFlashAttribute("tokenError", messageSource
					.getMessage("user.registration.verification.missing.token", null, LocaleContextHolder.getLocale()));
		}
		try {
			defaultUserService.verifyUser(token);
		} catch (com.rzk.RitzyGoat.core.utilities.security.springVerification.exception.InvalidTokenException e) {
			redirAttr.addFlashAttribute("tokenError", messageSource
					.getMessage("user.registration.verification.invalid.token", null, LocaleContextHolder.getLocale()));
		}

		return ResponseEntity.ok(new MessageResponse("User verification is successfully!"));

	}

	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

}
