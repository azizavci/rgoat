package com.rzk.RitzyGoat.core.utilities.security.springVerification.user.service;

import com.rzk.RitzyGoat.core.utilities.security.springVerification.exception.InvalidTokenException;
import com.rzk.RitzyGoat.core.utilities.security.springVerification.exception.UnknownIdentifierException;
import com.rzk.RitzyGoat.entities.concretes.Customer;
import com.rzk.RitzyGoat.entities.concretes.User;

public interface UserService {
	
	void register(final Customer user);

	boolean checkIfUserExist(final String email);

	void sendRegistrationConfirmationEmail(final Customer user);

	boolean verifyUser(final String token) throws InvalidTokenException;

	User getUserById(final String id) throws UnknownIdentifierException;
}
