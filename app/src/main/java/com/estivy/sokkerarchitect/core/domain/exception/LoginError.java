package com.estivy.sokkerarchitect.core.domain.exception;

import lombok.Getter;

public enum LoginError {
    BAD_PASSWORD(1, "bad password"),
    NO_TEAM(3, "user has no team"),
    BANNED(4, "user is banned"),
    BANKRUPT(5, "user is a bakrupt"),
    BLACKLISTED_IP(6, "user IP is blacklisted"),
    UNKNOWN(-1, "unknown error"),
    NO_XMLSESSID(-2, "XMLSESSID not found in sokker response"),
    NO_COOKIES(-3, "No cookies found in sokker response"),
    NO_TEAM_ID(-4, "Team id not found in sokker response");

    @Getter
    private int code;

    @Getter
    private String message;

    LoginError(int code, String message){
        this.code = code;
    }

    public static LoginError fromCode(int code){
        for(LoginError loginError : LoginError.values()){
            if(loginError.code == code){
                return loginError;
            }
        }
        return UNKNOWN;
    }

}

