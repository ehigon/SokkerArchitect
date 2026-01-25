package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "info")
public class LeagueInfoDto {

    @PropertyElement(name = "leagueID")
    private Long leagueId;

    @PropertyElement
    private String name;

    @PropertyElement(name = "countryID")
    private Long countryId;

    @PropertyElement
    private Integer division;

    @PropertyElement
    private Integer round;

    @PropertyElement
    private Integer season;

    @PropertyElement
    private Integer type;

    @PropertyElement(name = "isOfficial")
    private Integer official;

    @PropertyElement(name = "isCup")
    private Integer cup;

    @PropertyElement(name = "userID")
    private Long userId;

    public LeagueInfoDto() {
    }

    public LeagueInfoDto(Long leagueId, String name, Long countryId, Integer division,
                         Integer round, Integer season, Integer type, Integer official,
                         Integer cup, Long userId) {
        this.leagueId = leagueId;
        this.name = name;
        this.countryId = countryId;
        this.division = division;
        this.round = round;
        this.season = season;
        this.type = type;
        this.official = official;
        this.cup = cup;
        this.userId = userId;
    }

    public Long getLeagueId() { return leagueId; }
    public void setLeagueId(Long leagueId) { this.leagueId = leagueId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getCountryId() { return countryId; }
    public void setCountryId(Long countryId) { this.countryId = countryId; }

    public Integer getDivision() { return division; }
    public void setDivision(Integer division) { this.division = division; }

    public Integer getRound() { return round; }
    public void setRound(Integer round) { this.round = round; }

    public Integer getSeason() { return season; }
    public void setSeason(Integer season) { this.season = season; }

    public Integer getType() { return type; }
    public void setType(Integer type) { this.type = type; }

    public Integer getOfficial() { return official; }
    public void setOfficial(Integer official) { this.official = official; }

    public Integer getCup() { return cup; }
    public void setCup(Integer cup) { this.cup = cup; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long leagueId;
        private String name;
        private Long countryId;
        private Integer division;
        private Integer round;
        private Integer season;
        private Integer type;
        private Integer official;
        private Integer cup;
        private Long userId;

        public Builder leagueId(Long leagueId) { this.leagueId = leagueId; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder countryId(Long countryId) { this.countryId = countryId; return this; }
        public Builder division(Integer division) { this.division = division; return this; }
        public Builder round(Integer round) { this.round = round; return this; }
        public Builder season(Integer season) { this.season = season; return this; }
        public Builder type(Integer type) { this.type = type; return this; }
        public Builder official(Integer official) { this.official = official; return this; }
        public Builder cup(Integer cup) { this.cup = cup; return this; }
        public Builder userId(Long userId) { this.userId = userId; return this; }

        public LeagueInfoDto build() {
            return new LeagueInfoDto(leagueId, name, countryId, division, round,
                    season, type, official, cup, userId);
        }
    }
}
