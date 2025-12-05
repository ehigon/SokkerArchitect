package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "user")
public class UserDto {
    @PropertyElement(name = "userID")
    private String userId;
    @PropertyElement
    private String login;

    public UserDto() {
    }

    public UserDto(String userId, String login) {
        this.userId = userId;
        this.login = login;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String userId;
        private String login;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public UserDto build() {
            return new UserDto(userId, login);
        }
    }
}
