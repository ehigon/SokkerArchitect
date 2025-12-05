package com.estivy.sokkerarchitect.core.domain;

public class JuniorStatus {
    private Integer skill;
    private JuniorFormation formation;
    private Integer remainingWeeks;
    private Long week;
    private Integer age;
    private Integer trainerSkill;

    public JuniorStatus() {
    }

    public JuniorStatus(Integer skill, JuniorFormation formation, Integer remainingWeeks, Long week, Integer age, Integer trainerSkill) {
        this.skill = skill;
        this.formation = formation;
        this.remainingWeeks = remainingWeeks;
        this.week = week;
        this.age = age;
        this.trainerSkill = trainerSkill;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public JuniorFormation getFormation() {
        return formation;
    }

    public void setFormation(JuniorFormation formation) {
        this.formation = formation;
    }

    public Integer getRemainingWeeks() {
        return remainingWeeks;
    }

    public void setRemainingWeeks(Integer remainingWeeks) {
        this.remainingWeeks = remainingWeeks;
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

    public Integer getTrainerSkill() {
        return trainerSkill;
    }

    public void setTrainerSkill(Integer trainerSkill) {
        this.trainerSkill = trainerSkill;
    }

    public static JuniorStatusBuilder builder() {
        return new JuniorStatusBuilder();
    }

    public static class JuniorStatusBuilder {
        private Integer skill;
        private JuniorFormation formation;
        private Integer remainingWeeks;
        private Long week;
        private Integer age;
        private Integer trainerSkill;

        public JuniorStatusBuilder skill(Integer skill) {
            this.skill = skill;
            return this;
        }

        public JuniorStatusBuilder formation(JuniorFormation formation) {
            this.formation = formation;
            return this;
        }

        public JuniorStatusBuilder remainingWeeks(Integer remainingWeeks) {
            this.remainingWeeks = remainingWeeks;
            return this;
        }

        public JuniorStatusBuilder week(Long week) {
            this.week = week;
            return this;
        }

        public JuniorStatusBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public JuniorStatusBuilder trainerSkill(Integer trainerSkill) {
            this.trainerSkill = trainerSkill;
            return this;
        }

        public JuniorStatus build() {
            return new JuniorStatus(skill, formation, remainingWeeks, week, age, trainerSkill);
        }
    }
}
