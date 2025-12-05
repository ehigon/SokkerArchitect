package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;


@Xml(name = "playerStats")
public class PlayerStatDto {
    @PropertyElement(name = "playerID")
    private Long playerId;
    @PropertyElement
    private Integer number;
    @PropertyElement
    private Integer formation;
    @PropertyElement
    private Integer timeIn;
    @PropertyElement
    private Integer timeOut;
    @PropertyElement
    private Integer yellowCards;
    @PropertyElement
    private Integer redCards;
    @PropertyElement(name = "isInjured")
    private Integer injured;
    @PropertyElement
    private Integer goals;
    @PropertyElement
    private Integer assists;
    @PropertyElement
    private Integer fouls;
    @PropertyElement
    private Integer shoots;
    @PropertyElement
    private Integer rating;
    @PropertyElement
    private Integer timePlaying;
    @PropertyElement
    private Integer timeDefending;

    public PlayerStatDto() {
    }

    public PlayerStatDto(Long playerId, Integer number, Integer formation, Integer timeIn, Integer timeOut,
                         Integer yellowCards, Integer redCards, Integer injured, Integer goals, Integer assists,
                         Integer fouls, Integer shoots, Integer rating, Integer timePlaying, Integer timeDefending) {
        this.playerId = playerId;
        this.number = number;
        this.formation = formation;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.injured = injured;
        this.goals = goals;
        this.assists = assists;
        this.fouls = fouls;
        this.shoots = shoots;
        this.rating = rating;
        this.timePlaying = timePlaying;
        this.timeDefending = timeDefending;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getFormation() {
        return formation;
    }

    public void setFormation(Integer formation) {
        this.formation = formation;
    }

    public Integer getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Integer timeIn) {
        this.timeIn = timeIn;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
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

    public Integer getInjured() {
        return injured;
    }

    public void setInjured(Integer injured) {
        this.injured = injured;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getShoots() {
        return shoots;
    }

    public void setShoots(Integer shoots) {
        this.shoots = shoots;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getTimePlaying() {
        return timePlaying;
    }

    public void setTimePlaying(Integer timePlaying) {
        this.timePlaying = timePlaying;
    }

    public Integer getTimeDefending() {
        return timeDefending;
    }

    public void setTimeDefending(Integer timeDefending) {
        this.timeDefending = timeDefending;
    }

    public static PlayerStatDtoBuilder builder() {
        return new PlayerStatDtoBuilder();
    }

    public static class PlayerStatDtoBuilder {

        private Long playerId;
        private Integer number;
        private Integer formation;
        private Integer timeIn;
        private Integer timeOut;
        private Integer yellowCards;
        private Integer redCards;
        private Integer injured;
        private Integer goals;
        private Integer assists;
        private Integer fouls;
        private Integer shoots;
        private Integer rating;
        private Integer timePlaying;
        private Integer timeDefending;

        public PlayerStatDtoBuilder playerId(Long playerId) {
            this.playerId = playerId;
            return this;
        }

        public PlayerStatDtoBuilder number(Integer number) {
            this.number = number;
            return this;
        }

        public PlayerStatDtoBuilder formation(Integer formation) {
            this.formation = formation;
            return this;
        }

        public PlayerStatDtoBuilder timeIn(Integer timeIn) {
            this.timeIn = timeIn;
            return this;
        }

        public PlayerStatDtoBuilder timeOut(Integer timeOut) {
            this.timeOut = timeOut;
            return this;
        }

        public PlayerStatDtoBuilder yellowCards(Integer yellowCards) {
            this.yellowCards = yellowCards;
            return this;
        }

        public PlayerStatDtoBuilder redCards(Integer redCards) {
            this.redCards = redCards;
            return this;
        }

        public PlayerStatDtoBuilder injured(Integer injured) {
            this.injured = injured;
            return this;
        }

        public PlayerStatDtoBuilder goals(Integer goals) {
            this.goals = goals;
            return this;
        }

        public PlayerStatDtoBuilder assists(Integer assists) {
            this.assists = assists;
            return this;
        }

        public PlayerStatDtoBuilder fouls(Integer fouls) {
            this.fouls = fouls;
            return this;
        }

        public PlayerStatDtoBuilder shoots(Integer shoots) {
            this.shoots = shoots;
            return this;
        }

        public PlayerStatDtoBuilder rating(Integer rating) {
            this.rating = rating;
            return this;
        }

        public PlayerStatDtoBuilder timePlaying(Integer timePlaying) {
            this.timePlaying = timePlaying;
            return this;
        }

        public PlayerStatDtoBuilder timeDefending(Integer timeDefending) {
            this.timeDefending = timeDefending;
            return this;
        }

        public PlayerStatDto build() {
            return new PlayerStatDto(playerId, number, formation, timeIn, timeOut, yellowCards, redCards, injured,
                    goals, assists, fouls, shoots, rating, timePlaying, timeDefending);
        }

        @Override
        public String toString() {
            return "PlayerStatDto.PlayerStatDtoBuilder(" +
                    "playerId=" + playerId +
                    ", number=" + number +
                    ", formation=" + formation +
                    ", timeIn=" + timeIn +
                    ", timeOut=" + timeOut +
                    ", yellowCards=" + yellowCards +
                    ", redCards=" + redCards +
                    ", injured=" + injured +
                    ", goals=" + goals +
                    ", assists=" + assists +
                    ", fouls=" + fouls +
                    ", shoots=" + shoots +
                    ", rating=" + rating +
                    ", timePlaying=" + timePlaying +
                    ", timeDefending=" + timeDefending +
                    ")";
        }
    }
}
