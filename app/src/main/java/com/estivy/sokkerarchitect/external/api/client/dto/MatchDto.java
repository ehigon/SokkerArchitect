package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;


@Xml(name = "match")
public class MatchDto {

    @PropertyElement(name = "matchID")
    private Long matchId;
    @PropertyElement(name = "homeTeamID")
    private Long homeTeamId;
    @PropertyElement(name = "awayTeamID")
    private Long awayTeamId;
    @PropertyElement
    private String homeTeamName;
    @PropertyElement
    private String awayTeamName;
    @PropertyElement(name = "leagueID")
    private Long leagueId;
    @PropertyElement
    private Integer round;
    @PropertyElement
    private Integer season;
    @PropertyElement
    private Long week;
    @PropertyElement
    private Integer day;
    @PropertyElement
    private String dateExpected;
    @PropertyElement
    private String dateStarted;
    @PropertyElement
    private Integer homeTeamScore;
    @PropertyElement
    private Integer awayTeamScore;
    @PropertyElement
    private Integer supporters;
    @PropertyElement
    private Integer weather;
    @PropertyElement(name = "isFinished")
    private Integer finished;

    public MatchDto() {
    }

    public MatchDto(Long matchId, Long homeTeamId, Long awayTeamId, String homeTeamName, String awayTeamName,
                    Long leagueId, Integer round, Integer season, Long week, Integer day,
                    String dateExpected, String dateStarted, Integer homeTeamScore, Integer awayTeamScore,
                    Integer supporters, Integer weather, Integer finished) {
        this.matchId = matchId;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.leagueId = leagueId;
        this.round = round;
        this.season = season;
        this.week = week;
        this.day = day;
        this.dateExpected = dateExpected;
        this.dateStarted = dateStarted;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.supporters = supporters;
        this.weather = weather;
        this.finished = finished;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public Long getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(Long awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Long getWeek() {
        return week;
    }

    public void setWeek(Long week) {
        this.week = week;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getDateExpected() {
        return dateExpected;
    }

    public void setDateExpected(String dateExpected) {
        this.dateExpected = dateExpected;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(Integer homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(Integer awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public Integer getSupporters() {
        return supporters;
    }

    public void setSupporters(Integer supporters) {
        this.supporters = supporters;
    }

    public Integer getWeather() {
        return weather;
    }

    public void setWeather(Integer weather) {
        this.weather = weather;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public static MatchDtoBuilder builder() {
        return new MatchDtoBuilder();
    }

    public static class MatchDtoBuilder {

        private Long matchId;
        private Long homeTeamId;
        private Long awayTeamId;
        private String homeTeamName;
        private String awayTeamName;
        private Long leagueId;
        private Integer round;
        private Integer season;
        private Long week;
        private Integer day;
        private String dateExpected;
        private String dateStarted;
        private Integer homeTeamScore;
        private Integer awayTeamScore;
        private Integer supporters;
        private Integer weather;
        private Integer finished;

        MatchDtoBuilder() {
        }

        public MatchDtoBuilder matchId(Long matchId) {
            this.matchId = matchId;
            return this;
        }

        public MatchDtoBuilder homeTeamId(Long homeTeamId) {
            this.homeTeamId = homeTeamId;
            return this;
        }

        public MatchDtoBuilder awayTeamId(Long awayTeamId) {
            this.awayTeamId = awayTeamId;
            return this;
        }

        public MatchDtoBuilder homeTeamName(String homeTeamName) {
            this.homeTeamName = homeTeamName;
            return this;
        }

        public MatchDtoBuilder awayTeamName(String awayTeamName) {
            this.awayTeamName = awayTeamName;
            return this;
        }

        public MatchDtoBuilder leagueId(Long leagueId) {
            this.leagueId = leagueId;
            return this;
        }

        public MatchDtoBuilder round(Integer round) {
            this.round = round;
            return this;
        }

        public MatchDtoBuilder season(Integer season) {
            this.season = season;
            return this;
        }

        public MatchDtoBuilder week(Long week) {
            this.week = week;
            return this;
        }

        public MatchDtoBuilder day(Integer day) {
            this.day = day;
            return this;
        }

        public MatchDtoBuilder dateExpected(String dateExpected) {
            this.dateExpected = dateExpected;
            return this;
        }

        public MatchDtoBuilder dateStarted(String dateStarted) {
            this.dateStarted = dateStarted;
            return this;
        }

        public MatchDtoBuilder homeTeamScore(Integer homeTeamScore) {
            this.homeTeamScore = homeTeamScore;
            return this;
        }

        public MatchDtoBuilder awayTeamScore(Integer awayTeamScore) {
            this.awayTeamScore = awayTeamScore;
            return this;
        }

        public MatchDtoBuilder supporters(Integer supporters) {
            this.supporters = supporters;
            return this;
        }

        public MatchDtoBuilder weather(Integer weather) {
            this.weather = weather;
            return this;
        }

        public MatchDtoBuilder finished(Integer finished) {
            this.finished = finished;
            return this;
        }

        public MatchDto build() {
            return new MatchDto(
                    matchId, homeTeamId, awayTeamId, homeTeamName, awayTeamName,
                    leagueId, round, season, week, day, dateExpected, dateStarted,
                    homeTeamScore, awayTeamScore, supporters, weather, finished
            );
        }

        @Override
        public String toString() {
            return "MatchDto.MatchDtoBuilder(" +
                    "matchId=" + matchId +
                    ", homeTeamId=" + homeTeamId +
                    ", awayTeamId=" + awayTeamId +
                    ", homeTeamName=" + homeTeamName +
                    ", awayTeamName=" + awayTeamName +
                    ", leagueId=" + leagueId +
                    ", round=" + round +
                    ", season=" + season +
                    ", week=" + week +
                    ", day=" + day +
                    ", dateExpected=" + dateExpected +
                    ", dateStarted=" + dateStarted +
                    ", homeTeamScore=" + homeTeamScore +
                    ", awayTeamScore=" + awayTeamScore +
                    ", supporters=" + supporters +
                    ", weather=" + weather +
                    ", finished=" + finished +
                    ")";
        }
    }
}
