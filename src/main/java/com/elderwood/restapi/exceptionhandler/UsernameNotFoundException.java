package com.elderwood.restapi.exceptionhandler;

public class UsernameNotFoundException extends Exception{

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
