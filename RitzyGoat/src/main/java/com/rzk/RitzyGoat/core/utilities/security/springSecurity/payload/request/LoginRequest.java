package com.rzk.RitzyGoat.core.utilities.security.springSecurity.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {

	private String username;
	
	@NotBlank
	private String email;

	@NotBlank
	private String password;
	
	private boolean isVerified=false;
	
	
}
