package com.estivy.sokkerarchitect.external.api.client.dto;

public class LoginResultDto {
    String teamId;
    String xmlSession;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getXmlSession() {
        return xmlSession;
    }

    public void setXmlSession(String xmlSession) {
        this.xmlSession = xmlSession;
    }

    public LoginResultDto(String teamId, String xmlSession) {
        this.teamId = teamId;
        this.xmlSession = xmlSession;
    }

    public LoginResultDto() {
    }

    public static class Builder {
        private String teamId;
        private String xmlSession;

        public Builder teamId(String teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder xmlSession(String xmlSession) {
            this.xmlSession = xmlSession;
            return this;
        }

        public LoginResultDto build() {
            return new LoginResultDto(teamId, xmlSession);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
