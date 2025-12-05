package com.estivy.sokkerarchitect.core.domain.exception;


public class LoginException extends RuntimeException{

    private final LoginError loginError;

    public LoginException(LoginError loginError){
        super(loginError.getMessage());
        this.loginError = loginError;
    }

    public LoginError getLoginError(){
        return loginError;
    }

}
