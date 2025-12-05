package com.estivy.sokkerarchitect.storage.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.estivy.sokkerarchitect.core.domain.National;

@Entity(tableName = "players",
        foreignKeys = {
                @ForeignKey(entity = CountryEntity.class,
                        parentColumns = "countryId",
                        childColumns = "countryId")
        })
public class PlayerEntity {
    @PrimaryKey
    private Long id;
    private String name;
    private String surname;
    @ColumnInfo(index = true)
    private Integer countryId;
    private Integer age;
    private Integer height;
    private Double weight;
    private Double bmi;
    private Long teamId;
    private Long youthTeamId;
    private Long value;
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
    private boolean active;
    private String notes;

    public PlayerEntity() {
    }

    @Ignore
    public PlayerEntity(Long id, String name, String surname, Integer countryId, Integer age, Integer height,
                        Double weight, Double bmi, Long teamId, Long youthTeamId, Long value, Long wage,
                        Integer cards, Integer goals, Integer assists, Integer matches, Integer ntCards,
                        Integer ntGoals, Integer ntAssists, Integer ntMatches, Integer injuryDays,
                        National national, boolean active, String notes) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.teamId = teamId;
        this.youthTeamId = youthTeamId;
        this.value = value;
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
        this.active = active;
        this.notes = notes;
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

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private String surname;
        private Integer countryId;
        private Integer age;
        private Integer height;
        private Double weight;
        private Double bmi;
        private Long teamId;
        private Long youthTeamId;
        private Long value;
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
        private boolean active;
        private String notes;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder surname(String surname) { this.surname = surname; return this; }
        public Builder countryId(Integer countryId) { this.countryId = countryId; return this; }
        public Builder age(Integer age) { this.age = age; return this; }
        public Builder height(Integer height) { this.height = height; return this; }
        public Builder weight(Double weight) { this.weight = weight; return this; }
        public Builder bmi(Double bmi) { this.bmi = bmi; return this; }
        public Builder teamId(Long teamId) { this.teamId = teamId; return this; }
        public Builder youthTeamId(Long youthTeamId) { this.youthTeamId = youthTeamId; return this; }
        public Builder value(Long value) { this.value = value; return this; }
        public Builder wage(Long wage) { this.wage = wage; return this; }
        public Builder cards(Integer cards) { this.cards = cards; return this; }
        public Builder goals(Integer goals) { this.goals = goals; return this; }
        public Builder assists(Integer assists) { this.assists = assists; return this; }
        public Builder matches(Integer matches) { this.matches = matches; return this; }
        public Builder ntCards(Integer ntCards) { this.ntCards = ntCards; return this; }
        public Builder ntGoals(Integer ntGoals) { this.ntGoals = ntGoals; return this; }
        public Builder ntAssists(Integer ntAssists) { this.ntAssists = ntAssists; return this; }
        public Builder ntMatches(Integer ntMatches) { this.ntMatches = ntMatches; return this; }
        public Builder injuryDays(Integer injuryDays) { this.injuryDays = injuryDays; return this; }
        public Builder national(National national) { this.national = national; return this; }
        public Builder active(boolean active) { this.active = active; return this; }
        public Builder notes(String notes) { this.notes = notes; return this; }

        public PlayerEntity build() {
            return new PlayerEntity(id, name, surname, countryId, age, height, weight, bmi, teamId, youthTeamId,
                    value, wage, cards, goals, assists, matches, ntCards, ntGoals, ntAssists, ntMatches,
                    injuryDays, national, active, notes);
        }
    }
}
