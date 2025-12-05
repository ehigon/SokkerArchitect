package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "teamStats")
public class TeamStatsDto {

    @PropertyElement(name = "teamID")
    private Long teamId;
    @PropertyElement
    private Integer timeOnHalf;
    @PropertyElement
    private Integer timePossession;
    @PropertyElement
    private Integer offsides;
    @PropertyElement
    private Integer shoots;
    @PropertyElement
    private Integer fouls;
    @PropertyElement
    private Integer yellowCards;
    @PropertyElement
    private Integer redCards;
    @PropertyElement
    private String tacticName;
    @PropertyElement
    private Integer ratingScoring;
    @PropertyElement
    private Integer ratingPassing;
    @PropertyElement
    private Integer ratingDefending;

    public TeamStatsDto() {
    }

    public TeamStatsDto(Long teamId, Integer timeOnHalf, Integer timePossession, Integer offsides, Integer shoots,
                        Integer fouls, Integer yellowCards, Integer redCards, String tacticName,
                        Integer ratingScoring, Integer ratingPassing, Integer ratingDefending) {
        this.teamId = teamId;
        this.timeOnHalf = timeOnHalf;
        this.timePossession = timePossession;
        this.offsides = offsides;
        this.shoots = shoots;
        this.fouls = fouls;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.tacticName = tacticName;
        this.ratingScoring = ratingScoring;
        this.ratingPassing = ratingPassing;
        this.ratingDefending = ratingDefending;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Integer getTimeOnHalf() {
        return timeOnHalf;
    }

    public void setTimeOnHalf(Integer timeOnHalf) {
        this.timeOnHalf = timeOnHalf;
    }

    public Integer getTimePossession() {
        return timePossession;
    }

    public void setTimePossession(Integer timePossession) {
        this.timePossession = timePossession;
    }

    public Integer getOffsides() {
        return offsides;
    }

    public void setOffsides(Integer offsides) {
        this.offsides = offsides;
    }

    public Integer getShoots() {
        return shoots;
    }

    public void setShoots(Integer shoots) {
        this.shoots = shoots;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }

    public String getTacticName() {
        return tacticName;
    }

    public void setTacticName(String tacticName) {
        this.tacticName = tacticName;
    }

    public Integer getRatingScoring() {
        return ratingScoring;
    }

    public void setRatingScoring(Integer ratingScoring) {
        this.ratingScoring = ratingScoring;
    }

    public Integer getRatingPassing() {
        return ratingPassing;
    }

    public void setRatingPassing(Integer ratingPassing) {
        this.ratingPassing = ratingPassing;
    }

    public Integer getRatingDefending() {
        return ratingDefending;
    }

    public void setRatingDefending(Integer ratingDefending) {
        this.ratingDefending = ratingDefending;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long teamId;
        private Integer timeOnHalf;
        private Integer timePossession;
        private Integer offsides;
        private Integer shoots;
        private Integer fouls;
        private Integer yellowCards;
        private Integer redCards;
        private String tacticName;
        private Integer ratingScoring;
        private Integer ratingPassing;
        private Integer ratingDefending;

        public Builder teamId(Long teamId) { this.teamId = teamId; return this; }
        public Builder timeOnHalf(Integer timeOnHalf) { this.timeOnHalf = timeOnHalf; return this; }
        public Builder timePossession(Integer timePossession) { this.timePossession = timePossession; return this; }
        public Builder offsides(Integer offsides) { this.offsides = offsides; return this; }
        public Builder shoots(Integer shoots) { this.shoots = shoots; return this; }
        public Builder fouls(Integer fouls) { this.fouls = fouls; return this; }
        public Builder yellowCards(Integer yellowCards) { this.yellowCards = yellowCards; return this; }
        public Builder redCards(Integer redCards) { this.redCards = redCards; return this; }
        public Builder tacticName(String tacticName) { this.tacticName = tacticName; return this; }
        public Builder ratingScoring(Integer ratingScoring) { this.ratingScoring = ratingScoring; return this; }
        public Builder ratingPassing(Integer ratingPassing) { this.ratingPassing = ratingPassing; return this; }
        public Builder ratingDefending(Integer ratingDefending) { this.ratingDefending = ratingDefending; return this; }

        public TeamStatsDto build() {
            return new TeamStatsDto(teamId, timeOnHalf, timePossession, offsides, shoots, fouls, yellowCards,
                    redCards, tacticName, ratingScoring, ratingPassing, ratingDefending);
        }
    }
}
