package com.estivy.sokkerarchitect.core.domain;


import java.util.List;

public class Status {

    private List<Player> players;

    private Long week;

    private List<Country> countries;

    private Team team;

    public Status() {
    }

    public Status(List<Player> players, Long week, List<Country> countries, Team team) {
        this.players = players;
        this.week = week;
        this.countries = countries;
        this.team = team;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Long getWeek() {
        return week;
    }

    public void setWeek(Long week) {
        this.week = week;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public static StatusBuilder builder() {
        return new StatusBuilder();
    }

    public static class StatusBuilder {
        private List<Player> players;
        private Long week;
        private List<Country> countries;
        private Team team;

        StatusBuilder() {
        }

        public StatusBuilder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public StatusBuilder week(Long week) {
            this.week = week;
            return this;
        }

        public StatusBuilder countries(List<Country> countries) {
            this.countries = countries;
            return this;
        }

        public StatusBuilder team(Team team) {
            this.team = team;
            return this;
        }

        public Status build() {
            return new Status(players, week, countries, team);
        }

        @Override
        public String toString() {
            return "Status.StatusBuilder(players=" + this.players +
                    ", week=" + this.week +
                    ", countries=" + this.countries +
                    ", team=" + this.team + ")";
        }
    }
}
