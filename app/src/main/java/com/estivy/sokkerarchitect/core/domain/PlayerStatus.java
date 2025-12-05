package com.estivy.sokkerarchitect.core.domain;

public class PlayerStatus {

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
    private TrainingType trainingType;
    private Integer officialMinutes;
    private Integer unofficialMinutes;
    private Integer trainerSkill;
    private Long week;
    private Integer age;
    private Boolean injured;

    public PlayerStatus() {
    }

    public PlayerStatus(Integer skillForm, Integer skillExperience, Integer skillTeamwork, Integer skillDiscipline, Integer transferList, Integer skillStamina, Integer skillPace, Integer skillTechnique, Integer skillPassing, Integer skillKeeper, Integer skillDefending, Integer skillPlaymaking, Integer skillScoring, TrainingType trainingType, Integer officialMinutes, Integer unofficialMinutes, Integer trainerSkill, Long week, Integer age, Boolean injured) {
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
        this.trainingType = trainingType;
        this.officialMinutes = officialMinutes;
        this.unofficialMinutes = unofficialMinutes;
        this.trainerSkill = trainerSkill;
        this.week = week;
        this.age = age;
        this.injured = injured;
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

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    public Integer getOfficialMinutes() {
        return officialMinutes;
    }

    public void setOfficialMinutes(Integer officialMinutes) {
        this.officialMinutes = officialMinutes;
    }

    public Integer getUnofficialMinutes() {
        return unofficialMinutes;
    }

    public void setUnofficialMinutes(Integer unofficialMinutes) {
        this.unofficialMinutes = unofficialMinutes;
    }

    public Integer getTrainerSkill() {
        return trainerSkill;
    }

    public void setTrainerSkill(Integer trainerSkill) {
        this.trainerSkill = trainerSkill;
    }

    public Long getWeek() {
        return week;
    }

    public void setWeek(Long week) {
        this.week = week;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getInjured() {
        return injured;
    }

    public void setInjured(Boolean injured) {
        this.injured = injured;
    }

    public static PlayerStatusBuilder builder() {
        return new PlayerStatusBuilder();
    }

    public static class PlayerStatusBuilder {
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
        private TrainingType trainingType;
        private Integer officialMinutes;
        private Integer unofficialMinutes;
        private Integer trainerSkill;
        private Long week;
        private Integer age;
        private Boolean injured;

        public PlayerStatusBuilder skillForm(Integer skillForm) {
            this.skillForm = skillForm;
            return this;
        }

        public PlayerStatusBuilder skillExperience(Integer skillExperience) {
            this.skillExperience = skillExperience;
            return this;
        }

        public PlayerStatusBuilder skillTeamwork(Integer skillTeamwork) {
            this.skillTeamwork = skillTeamwork;
            return this;
        }

        public PlayerStatusBuilder skillDiscipline(Integer skillDiscipline) {
            this.skillDiscipline = skillDiscipline;
            return this;
        }

        public PlayerStatusBuilder transferList(Integer transferList) {
            this.transferList = transferList;
            return this;
        }

        public PlayerStatusBuilder skillStamina(Integer skillStamina) {
            this.skillStamina = skillStamina;
            return this;
        }

        public PlayerStatusBuilder skillPace(Integer skillPace) {
            this.skillPace = skillPace;
            return this;
        }

        public PlayerStatusBuilder skillTechnique(Integer skillTechnique) {
            this.skillTechnique = skillTechnique;
            return this;
        }

        public PlayerStatusBuilder skillPassing(Integer skillPassing) {
            this.skillPassing = skillPassing;
            return this;
        }

        public PlayerStatusBuilder skillKeeper(Integer skillKeeper) {
            this.skillKeeper = skillKeeper;
            return this;
        }

        public PlayerStatusBuilder skillDefending(Integer skillDefending) {
            this.skillDefending = skillDefending;
            return this;
        }

        public PlayerStatusBuilder skillPlaymaking(Integer skillPlaymaking) {
            this.skillPlaymaking = skillPlaymaking;
            return this;
        }

        public PlayerStatusBuilder skillScoring(Integer skillScoring) {
            this.skillScoring = skillScoring;
            return this;
        }

        public PlayerStatusBuilder trainingType(TrainingType trainingType) {
            this.trainingType = trainingType;
            return this;
        }

        public PlayerStatusBuilder officialMinutes(Integer officialMinutes) {
            this.officialMinutes = officialMinutes;
            return this;
        }

        public PlayerStatusBuilder unofficialMinutes(Integer unofficialMinutes) {
            this.unofficialMinutes = unofficialMinutes;
            return this;
        }

        public PlayerStatusBuilder trainerSkill(Integer trainerSkill) {
            this.trainerSkill = trainerSkill;
            return this;
        }

        public PlayerStatusBuilder week(Long week) {
            this.week = week;
            return this;
        }

        public PlayerStatusBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public PlayerStatusBuilder injured(Boolean injured) {
            this.injured = injured;
            return this;
        }

        public PlayerStatus build() {
            return new PlayerStatus(
                    skillForm, skillExperience, skillTeamwork, skillDiscipline, transferList, skillStamina,
                    skillPace, skillTechnique, skillPassing, skillKeeper, skillDefending, skillPlaymaking,
                    skillScoring, trainingType, officialMinutes, unofficialMinutes, trainerSkill, week,
                    age, injured
            );
        }
    }
}
