package com.estivy.sokkerarchitect.core.domain.exception;

public class CredentialsLoginException extends LoginException {

    public CredentialsLoginException(LoginError loginError) {
        super(loginError);
    }
}

