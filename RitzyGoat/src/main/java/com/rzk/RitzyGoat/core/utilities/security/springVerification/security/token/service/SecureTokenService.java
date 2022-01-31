package com.rzk.RitzyGoat.core.utilities.security.springVerification.security.token.service;

import com.rzk.RitzyGoat.entities.concretes.SecureToken;

public interface SecureTokenService {

	SecureToken createSecureToken();

	void saveSecureToken(final SecureToken token);

	SecureToken findByToken(final String token);

	void removeToken(final SecureToken token);

	void removeTokenByToken(final String token);

}
