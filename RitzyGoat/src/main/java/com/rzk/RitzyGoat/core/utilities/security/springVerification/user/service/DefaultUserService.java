package com.rzk.RitzyGoat.core.utilities.security.springVerification.user.service;

import java.util.Objects;

import javax.mail.MessagingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.core.utilities.security.springVerification.email.context.AccountVerificationEmailContext;
import com.rzk.RitzyGoat.core.utilities.security.springVerification.email.service.EmailService;
import com.rzk.RitzyGoat.core.utilities.security.springVerification.exception.InvalidTokenException;
import com.rzk.RitzyGoat.core.utilities.security.springVerification.exception.UnknownIdentifierException;
import com.rzk.RitzyGoat.core.utilities.security.springVerification.security.token.service.SecureTokenService;
import com.rzk.RitzyGoat.dataAccess.abstracts.CustomerDao;
import com.rzk.RitzyGoat.dataAccess.abstracts.SecureTokenDao;
import com.rzk.RitzyGoat.dataAccess.abstracts.UserDao;
import com.rzk.RitzyGoat.entities.concretes.Customer;
import com.rzk.RitzyGoat.entities.concretes.SecureToken;
import com.rzk.RitzyGoat.entities.concretes.User;

@Service
public class DefaultUserService implements UserService {

	@Autowired
	private CustomerDao userRepository;

	@Autowired
	private EmailService emailService;

	@Autowired
	private SecureTokenService secureTokenService;

	@Autowired
	SecureTokenDao secureTokenRepository;

	@Value("${site.base.url.https}")
	private String baseURL;

	@Override
	public void register(Customer user){
		Customer userEntity = new Customer();
		BeanUtils.copyProperties(user, userEntity);
		userRepository.save(userEntity);
		//sendRegistrationConfirmationEmail(userEntity);

	}

	@Override
	public void sendRegistrationConfirmationEmail(Customer user) {
		SecureToken secureToken = secureTokenService.createSecureToken();
		secureToken.setUser(user);
		secureTokenRepository.save(secureToken);
		AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
		emailContext.init(user);
		emailContext.setToken(secureToken.getToken());
		emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
		try {
			emailService.sendMail(emailContext);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean checkIfUserExist(String email) {
		return userRepository.findByEmail(email) != null ? true : false;
	}

	@Override
	public boolean verifyUser(String token) throws InvalidTokenException {
		SecureToken secureToken = secureTokenService.findByToken(token);
		if (Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken())
				|| secureToken.isExpired()) {
			throw new InvalidTokenException("Token is not valid");
		}
		Customer user = userRepository.getOne(secureToken.getUser().getId());
		if (Objects.isNull(user)) {
			return false;
		}
		user.setVerified(true);
		userRepository.save(user); // let's same user details

		// we don't need invalid password now
		secureTokenService.removeToken(secureToken);
		return true;
	}

	@Override
	public User getUserById(String email) throws UnknownIdentifierException {
		Customer user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

		return user;
	}

}
