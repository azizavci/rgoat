package com.rzk.RitzyGoat.core.utilities.security.springVerification.email.service;

import javax.mail.MessagingException;

import com.rzk.RitzyGoat.core.utilities.security.springVerification.email.context.AbstractEmailContext;

public interface EmailService {
	
    void sendMail(final AbstractEmailContext email) throws MessagingException;

}
