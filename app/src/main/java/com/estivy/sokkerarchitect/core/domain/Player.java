package com.estivy.sokkerarchitect.core.domain;

import java.util.List;

public class Player {

    private List<PlayerStatus> playerStatuses;

    private List<JuniorStatus> juniorStatuses;

    private Long id;
    private String name;
    private String surname;
    private Country country;
    private Integer age;
    private Integer height;
    private Double weight;
    private Double bmi;
    private Long teamId;
    private Long youthTeamId;
    private Long value;
    private Double valueInCurrency;
    private String currency;
    private Long wage;
    private Integer cards;
    private Integer goals;
    private Integer assists;
    private Integer matches;
    private Integer ntCards;
    private Integer ntGoals;
    private Integer ntAssists;
    private Integer ntMatches;
    private Integer injuryDays;
    private National national;
    private String notes;

    public Player() {
    }

    public Player(List<PlayerStatus> playerStatuses, List<JuniorStatus> juniorStatuses, Long id, String name, String surname, Country country, Integer age, Integer height, Double weight, Double bmi, Long teamId, Long youthTeamId, Long value, Double valueInCurrency, String currency, Long wage, Integer cards, Integer goals, Integer assists, Integer matches, Integer ntCards, Integer ntGoals, Integer ntAssists, Integer ntMatches, Integer injuryDays, National national, String notes) {
        this.playerStatuses = playerStatuses;
        this.juniorStatuses = juniorStatuses;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.teamId = teamId;
        this.youthTeamId = youthTeamId;
        this.value = value;
        this.valueInCurrency = valueInCurrency;
        this.currency = currency;
        this.wage = wage;
        this.cards = cards;
        this.goals = goals;
        this.assists = assists;
        this.matches = matches;
        this.ntCards = ntCards;
        this.ntGoals = ntGoals;
        this.ntAssists = ntAssists;
        this.ntMatches = ntMatches;
        this.injuryDays = injuryDays;
        this.national = national;
        this.notes = notes;
    }

    public List<PlayerStatus> getPlayerStatuses() {
        return playerStatuses;
    }

    public void setPlayerStatuses(List<PlayerStatus> playerStatuses) {
        this.playerStatuses = playerStatuses;
    }

    public List<JuniorStatus> getJuniorStatuses() {
        return juniorStatuses;
    }

    public void setJuniorStatuses(List<JuniorStatus> juniorStatuses) {
        this.juniorStatuses = juniorStatuses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getYouthTeamId() {
        return youthTeamId;
    }

    public void setYouthTeamId(Long youthTeamId) {
        this.youthTeamId = youthTeamId;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Double getValueInCurrency() {
        return valueInCurrency;
    }

    public void setValueInCurrency(Double valueInCurrency) {
        this.valueInCurrency = valueInCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getWage() {
        return wage;
    }

    public void setWage(Long wage) {
        this.wage = wage;
    }

    public Integer getCards() {
        return cards;
    }

    public void setCards(Integer cards) {
        this.cards = cards;
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

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Integer getNtCards() {
        return ntCards;
    }

    public void setNtCards(Integer ntCards) {
        this.ntCards = ntCards;
    }

    public Integer getNtGoals() {
        return ntGoals;
    }

    public void setNtGoals(Integer ntGoals) {
        this.ntGoals = ntGoals;
    }

    public Integer getNtAssists() {
        return ntAssists;
    }

    public void setNtAssists(Integer ntAssists) {
        this.ntAssists = ntAssists;
    }

    public Integer getNtMatches() {
        return ntMatches;
    }

    public void setNtMatches(Integer ntMatches) {
        this.ntMatches = ntMatches;
    }

    public Integer getInjuryDays() {
        return injuryDays;
    }

    public void setInjuryDays(Integer injuryDays) {
        this.injuryDays = injuryDays;
    }

    public National getNational() {
        return national;
    }

    public void setNational(National national) {
        this.national = national;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

    public static class PlayerBuilder {
        private List<PlayerStatus> playerStatuses;
        private List<JuniorStatus> juniorStatuses;

        private Long id;
        private String name;
        private String surname;
        private Country country;
        private Integer age;
        private Integer height;
        private Double weight;
        private Double bmi;
        private Long teamId;
        private Long youthTeamId;
        private Long value;
        private Double valueInCurrency;
        private String currency;
        private Long wage;
        private Integer cards;
        private Integer goals;
        private Integer assists;
        private Integer matches;
        private Integer ntCards;
        private Integer ntGoals;
        private Integer ntAssists;
        private Integer ntMatches;
        private Integer injuryDays;
        private National national;
        private String notes;

        public PlayerBuilder playerStatuses(List<PlayerStatus> playerStatuses) {
            this.playerStatuses = playerStatuses;
            return this;
        }

        public PlayerBuilder juniorStatuses(List<JuniorStatus> juniorStatuses) {
            this.juniorStatuses = juniorStatuses;
            return this;
        }

        public PlayerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public PlayerBuilder country(Country country) {
            this.country = country;
            return this;
        }

        public PlayerBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public PlayerBuilder height(Integer height) {
            this.height = height;
            return this;
        }

        public PlayerBuilder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public PlayerBuilder bmi(Double bmi) {
            this.bmi = bmi;
            return this;
        }

        public PlayerBuilder teamId(Long teamId) {
            this.teamId = teamId;
            return this;
        }

        public PlayerBuilder youthTeamId(Long youthTeamId) {
            this.youthTeamId = youthTeamId;
            return this;
        }

        public PlayerBuilder value(Long value) {
            this.value = value;
            return this;
        }

        public PlayerBuilder valueInCurrency(Double valueInCurrency) {
            this.valueInCurrency = valueInCurrency;
            return this;
        }

        public PlayerBuilder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public PlayerBuilder wage(Long wage) {
            this.wage = wage;
            return this;
        }

        public PlayerBuilder cards(Integer cards) {
            this.cards = cards;
            return this;
        }

        public PlayerBuilder goals(Integer goals) {
            this.goals = goals;
            return this;
        }

        public PlayerBuilder assists(Integer assists) {
            this.assists = assists;
            return this;
        }

        public PlayerBuilder matches(Integer matches) {
            this.matches = matches;
            return this;
        }

        public PlayerBuilder ntCards(Integer ntCards) {
            this.ntCards = ntCards;
            return this;
        }

        public PlayerBuilder ntGoals(Integer ntGoals) {
            this.ntGoals = ntGoals;
            return this;
        }

        public PlayerBuilder ntAssists(Integer ntAssists) {
            this.ntAssists = ntAssists;
            return this;
        }

        public PlayerBuilder ntMatches(Integer ntMatches) {
            this.ntMatches = ntMatches;
            return this;
        }

        public PlayerBuilder injuryDays(Integer injuryDays) {
            this.injuryDays = injuryDays;
            return this;
        }

        public PlayerBuilder national(National national) {
            this.national = national;
            return this;
        }

        public PlayerBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Player build() {
            return new Player(
                    playerStatuses, juniorStatuses, id, name, surname, country, age,
                    height, weight, bmi, teamId, youthTeamId, value, valueInCurrency,
                    currency, wage, cards, goals, assists, matches, ntCards, ntGoals,
                    ntAssists, ntMatches, injuryDays, national, notes
            );
        }
    }
}
