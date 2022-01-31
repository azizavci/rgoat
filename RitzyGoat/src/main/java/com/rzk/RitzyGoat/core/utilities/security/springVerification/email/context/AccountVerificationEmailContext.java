package com.rzk.RitzyGoat.core.utilities.security.springVerification.email.context;

import org.springframework.web.util.UriComponentsBuilder;

import com.rzk.RitzyGoat.entities.concretes.User;

public class AccountVerificationEmailContext extends AbstractEmailContext {

	private String token;


    @Override
    public <T> void init(T context){
        //we can do any common configuration setup here
        // like setting up some base URL and context
        User customer = (User) context; // we pass the customer informati
        put("firstName", customer.getUsername());
        setTemplateLocation("emails/email-verification");
        setSubject("Complete your registration");
        setFrom("azizavci.x@gmail.com");
        setTo(customer.getEmail());
    }


	public void setToken(String token) {
        this.token = token;
        put("token", token);
    }

    public void buildVerificationUrl(final String baseURL, final String token){
        final String url= UriComponentsBuilder.fromHttpUrl(baseURL)
                .path("/api/auth/verify").queryParam("token", token).toUriString();
        put("verificationURL", url);
    }
	
}
