package com.rzk.RitzyGoat.core.utilities.security.springVerification.exception;

public class UserAlreadyExistException extends Exception{

	public UserAlreadyExistException() {
        super();
    }


    public UserAlreadyExistException(String message) {
        super(message);
    }


    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
