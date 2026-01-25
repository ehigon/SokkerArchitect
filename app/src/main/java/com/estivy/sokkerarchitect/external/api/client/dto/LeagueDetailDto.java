package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

@Xml
public class LeagueDetailDto {

    @Element
    private LeagueInfoDto info;

    public LeagueDetailDto() {
    }

    public LeagueDetailDto(LeagueInfoDto info) {
        this.info = info;
    }

    public LeagueInfoDto getInfo() {
        return info;
    }

    public void setInfo(LeagueInfoDto info) {
        this.info = info;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private LeagueInfoDto info;

        public Builder info(LeagueInfoDto info) {
            this.info = info;
            return this;
        }

        public LeagueDetailDto build() {
            return new LeagueDetailDto(info);
        }
    }

}
