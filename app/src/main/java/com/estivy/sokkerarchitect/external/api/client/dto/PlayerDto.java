package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "player")
public class PlayerDto {
    @PropertyElement(name = "ID")
    private Long id;
    @PropertyElement
    private String name;
    @PropertyElement
    private String surname;
    @PropertyElement(name = "countryID")
    private Integer countryId;
    @PropertyElement
    private Integer age;
    @PropertyElement
    private Integer height;
    @PropertyElement
    private Double weight;
    @PropertyElement(name = "BMI")
    private Double bmi;
    @PropertyElement(name = "teamID")
    private Long teamId;
    @PropertyElement(name = "youthTeamID")
    private Long youthTeamId;
    @PropertyElement
    private Long value;
    @PropertyElement
    private Long wage;
    @PropertyElement
    private Integer cards;
    @PropertyElement
    private Integer goals;
    @PropertyElement
    private Integer assists;
    @PropertyElement
    private Integer matches;
    @PropertyElement
    private Integer ntCards;
    @PropertyElement
    private Integer ntGoals;
    @PropertyElement
    private Integer ntAssists;
    @PropertyElement
    private Integer ntMatches;
    @PropertyElement
    private Integer injuryDays;
    @PropertyElement
    private Integer national;
    @PropertyElement
    private Integer skillForm;
    @PropertyElement
    private Integer skillExperience;
    @PropertyElement
    private Integer skillTeamwork;
    @PropertyElement
    private Integer skillDiscipline;
    @PropertyElement
    private Integer transferList;
    @PropertyElement
    private Integer skillStamina;
    @PropertyElement
    private Integer skillPace;
    @PropertyElement
    private Integer skillTechnique;
    @PropertyElement
    private Integer skillPassing;
    @PropertyElement
    private Integer skillKeeper;
    @PropertyElement
    private Integer skillDefending;
    @PropertyElement
    private Integer skillPlaymaking;
    @PropertyElement
    private Integer skillScoring;
    @PropertyElement
    private Integer trainingPosition;
    @PropertyElement(name= "isInTrainingSlot")
    private Boolean inTrainingSlot;

    public PlayerDto() {
    }

    public PlayerDto(Long id, String name, String surname, Integer countryId, Integer age, Integer height, Double weight, Double bmi, Long teamId, Long youthTeamId, Long value, Long wage, Integer cards, Integer goals, Integer assists, Integer matches, Integer ntCards, Integer ntGoals, Integer ntAssists, Integer ntMatches, Integer injuryDays, Integer national, Integer skillForm, Integer skillExperience, Integer skillTeamwork, Integer skillDiscipline, Integer transferList, Integer skillStamina, Integer skillPace, Integer skillTechnique, Integer skillPassing, Integer skillKeeper, Integer skillDefending, Integer skillPlaymaking, Integer skillScoring, Integer trainingPosition, Boolean inTrainingSlot) {
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
        this.skillForm = skillForm;
        this.skillExperience = skillExperience;
        this.skillTeamwork = skillTeamwork;
        this.skillDiscipline = skillDiscipline;
        this.transferList = transferList;
        this.skillStamina = skillStamina;
        this.skillPace = skillPace;
        this.skillTechnique = skillTechnique;
        this.skillPassing = skillPassing;
        this.skillKeeper = skillKeeper;
        this.skillDefending = skillDefending;
        this.skillPlaymaking = skillPlaymaking;
        this.skillScoring = skillScoring;
        this.trainingPosition = trainingPosition;
        this.inTrainingSlot = inTrainingSlot;
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

    public Integer getNational() {
        return national;
    }

    public void setNational(Integer national) {
        this.national = national;
    }

    public Integer getSkillForm() {
        return skillForm;
    }

    public void setSkillForm(Integer skillForm) {
        this.skillForm = skillForm;
    }

    public Integer getSkillExperience() {
        return skillExperience;
    }

    public void setSkillExperience(Integer skillExperience) {
        this.skillExperience = skillExperience;
    }

    public Integer getSkillTeamwork() {
        return skillTeamwork;
    }

    public void setSkillTeamwork(Integer skillTeamwork) {
        this.skillTeamwork = skillTeamwork;
    }

    public Integer getSkillDiscipline() {
        return skillDiscipline;
    }

    public void setSkillDiscipline(Integer skillDiscipline) {
        this.skillDiscipline = skillDiscipline;
    }

    public Integer getTransferList() {
        return transferList;
    }

    public void setTransferList(Integer transferList) {
        this.transferList = transferList;
    }

    public Integer getSkillStamina() {
        return skillStamina;
    }

    public void setSkillStamina(Integer skillStamina) {
        this.skillStamina = skillStamina;
    }

    public Integer getSkillPace() {
        return skillPace;
    }

    public void setSkillPace(Integer skillPace) {
        this.skillPace = skillPace;
    }

    public Integer getSkillTechnique() {
        return skillTechnique;
    }

    public void setSkillTechnique(Integer skillTechnique) {
        this.skillTechnique = skillTechnique;
    }

    public Integer getSkillPassing() {
        return skillPassing;
    }

    public void setSkillPassing(Integer skillPassing) {
        this.skillPassing = skillPassing;
    }

    public Integer getSkillKeeper() {
        return skillKeeper;
    }

    public void setSkillKeeper(Integer skillKeeper) {
        this.skillKeeper = skillKeeper;
    }

    public Integer getSkillDefending() {
        return skillDefending;
    }

    public void setSkillDefending(Integer skillDefending) {
        this.skillDefending = skillDefending;
    }

    public Integer getSkillPlaymaking() {
        return skillPlaymaking;
    }

    public void setSkillPlaymaking(Integer skillPlaymaking) {
        this.skillPlaymaking = skillPlaymaking;
    }

    public Integer getSkillScoring() {
        return skillScoring;
    }

    public void setSkillScoring(Integer skillScoring) {
        this.skillScoring = skillScoring;
    }

    public Integer getTrainingPosition() {
        return trainingPosition;
    }

    public void setTrainingPosition(Integer trainingPosition) {
        this.trainingPosition = trainingPosition;
    }

    public Boolean getInTrainingSlot() {
        return inTrainingSlot;
    }

    public void setInTrainingSlot(Boolean inTrainingSlot) {
        this.inTrainingSlot = inTrainingSlot;
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
        private Integer national;
        private Integer skillForm;
        private Integer skillExperience;
        private Integer skillTeamwork;
        private Integer skillDiscipline;
        private Integer transferList;
        private Integer skillStamina;
        private Integer skillPace;
        private Integer skillTechnique;
        private Integer skillPassing;
        private Integer skillKeeper;
        private Integer skillDefending;
        private Integer skillPlaymaking;
        private Integer skillScoring;
        private Integer trainingPosition;
        private Boolean inTrainingSlot;

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
        public Builder national(Integer national) { this.national = national; return this; }
        public Builder skillForm(Integer skillForm) { this.skillForm = skillForm; return this; }
        public Builder skillExperience(Integer skillExperience) { this.skillExperience = skillExperience; return this; }
        public Builder skillTeamwork(Integer skillTeamwork) { this.skillTeamwork = skillTeamwork; return this; }
        public Builder skillDiscipline(Integer skillDiscipline) { this.skillDiscipline = skillDiscipline; return this; }
        public Builder transferList(Integer transferList) { this.transferList = transferList; return this; }
        public Builder skillStamina(Integer skillStamina) { this.skillStamina = skillStamina; return this; }
        public Builder skillPace(Integer skillPace) { this.skillPace = skillPace; return this; }
        public Builder skillTechnique(Integer skillTechnique) { this.skillTechnique = skillTechnique; return this; }
        public Builder skillPassing(Integer skillPassing) { this.skillPassing = skillPassing; return this; }
        public Builder skillKeeper(Integer skillKeeper) { this.skillKeeper = skillKeeper; return this; }
        public Builder skillDefending(Integer skillDefending) { this.skillDefending = skillDefending; return this; }
        public Builder skillPlaymaking(Integer skillPlaymaking) { this.skillPlaymaking = skillPlaymaking; return this; }
        public Builder skillScoring(Integer skillScoring) { this.skillScoring = skillScoring; return this; }
        public Builder trainingPosition(Integer trainingPosition) { this.trainingPosition = trainingPosition; return this; }
        public Builder inTrainingSlot(Boolean inTrainingSlot) { this.inTrainingSlot = inTrainingSlot; return this; }

        public PlayerDto build() {
            return new PlayerDto(id, name, surname, countryId, age, height, weight, bmi, teamId, youthTeamId, value, wage, cards, goals, assists, matches, ntCards, ntGoals, ntAssists, ntMatches, injuryDays, national, skillForm, skillExperience, skillTeamwork, skillDiscipline, transferList, skillStamina, skillPace, skillTechnique, skillPassing, skillKeeper, skillDefending, skillPlaymaking, skillScoring, trainingPosition, inTrainingSlot);
        }
    }
}
