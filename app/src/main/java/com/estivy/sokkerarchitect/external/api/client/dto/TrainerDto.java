package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml(name = "trainer")
public class TrainerDto {

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
    @PropertyElement(name = "teamID")
    private Long teamId;
    @PropertyElement
    private Integer wage;
    @PropertyElement
    private Integer signedContract;
    @PropertyElement
    private Integer job;
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
    private Integer skillCoach;

    public TrainerDto() {
    }

    public TrainerDto(Long id, String name, String surname, Integer countryId, Integer age, Long teamId,
                      Integer wage, Integer signedContract, Integer job, Integer skillStamina, Integer skillPace,
                      Integer skillTechnique, Integer skillPassing, Integer skillKeeper, Integer skillDefending,
                      Integer skillPlaymaking, Integer skillScoring, Integer skillCoach) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
        this.age = age;
        this.teamId = teamId;
        this.wage = wage;
        this.signedContract = signedContract;
        this.job = job;
        this.skillStamina = skillStamina;
        this.skillPace = skillPace;
        this.skillTechnique = skillTechnique;
        this.skillPassing = skillPassing;
        this.skillKeeper = skillKeeper;
        this.skillDefending = skillDefending;
        this.skillPlaymaking = skillPlaymaking;
        this.skillScoring = skillScoring;
        this.skillCoach = skillCoach;
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

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Integer getWage() {
        return wage;
    }

    public void setWage(Integer wage) {
        this.wage = wage;
    }

    public Integer getSignedContract() {
        return signedContract;
    }

    public void setSignedContract(Integer signedContract) {
        this.signedContract = signedContract;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
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

    public Integer getSkillCoach() {
        return skillCoach;
    }

    public void setSkillCoach(Integer skillCoach) {
        this.skillCoach = skillCoach;
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
        private Long teamId;
        private Integer wage;
        private Integer signedContract;
        private Integer job;
        private Integer skillStamina;
        private Integer skillPace;
        private Integer skillTechnique;
        private Integer skillPassing;
        private Integer skillKeeper;
        private Integer skillDefending;
        private Integer skillPlaymaking;
        private Integer skillScoring;
        private Integer skillCoach;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder surname(String surname) { this.surname = surname; return this; }
        public Builder countryId(Integer countryId) { this.countryId = countryId; return this; }
        public Builder age(Integer age) { this.age = age; return this; }
        public Builder teamId(Long teamId) { this.teamId = teamId; return this; }
        public Builder wage(Integer wage) { this.wage = wage; return this; }
        public Builder signedContract(Integer signedContract) { this.signedContract = signedContract; return this; }
        public Builder job(Integer job) { this.job = job; return this; }
        public Builder skillStamina(Integer skillStamina) { this.skillStamina = skillStamina; return this; }
        public Builder skillPace(Integer skillPace) { this.skillPace = skillPace; return this; }
        public Builder skillTechnique(Integer skillTechnique) { this.skillTechnique = skillTechnique; return this; }
        public Builder skillPassing(Integer skillPassing) { this.skillPassing = skillPassing; return this; }
        public Builder skillKeeper(Integer skillKeeper) { this.skillKeeper = skillKeeper; return this; }
        public Builder skillDefending(Integer skillDefending) { this.skillDefending = skillDefending; return this; }
        public Builder skillPlaymaking(Integer skillPlaymaking) { this.skillPlaymaking = skillPlaymaking; return this; }
        public Builder skillScoring(Integer skillScoring) { this.skillScoring = skillScoring; return this; }
        public Builder skillCoach(Integer skillCoach) { this.skillCoach = skillCoach; return this; }

        public TrainerDto build() {
            return new TrainerDto(id, name, surname, countryId, age, teamId, wage, signedContract, job, skillStamina,
                    skillPace, skillTechnique, skillPassing, skillKeeper, skillDefending, skillPlaymaking,
                    skillScoring, skillCoach);
        }
    }
}
