package com.estivy.sokkerarchitect.core.domain.exception;

import lombok.Getter;

public class LoginException extends RuntimeException{

    @Getter
    private final LoginError loginError;

    public LoginException(LoginError loginError){
        super(loginError.getMessage());
        this.loginError = loginError;
    }

}
