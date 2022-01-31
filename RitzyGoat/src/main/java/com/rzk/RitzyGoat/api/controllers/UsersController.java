package com.rzk.RitzyGoat.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.business.abstracts.UserService;
import com.rzk.RitzyGoat.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;

	}

	@PostMapping("/add/user")
	public Result addUser(@RequestBody User user) {

		return this.userService.add(user);

	}

	

	@GetMapping("/getAll")
	public DataResult<List<User>> getAll() {

		return this.userService.getAll();

	}
	
	/*
	 * @PostMapping("/add/role") public Result addRole(@RequestBody Role role) {
	 * 
	 * return this.userService.addRole(role);
	 * 
	 * }
	 */

}
