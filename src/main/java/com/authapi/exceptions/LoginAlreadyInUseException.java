package com.authapi.exceptions;

public class LoginAlreadyInUseException extends RuntimeException {

    public LoginAlreadyInUseException(Object login) {
        super("The username " + login + " is already in use. Please choose a different one.");
    }
}
