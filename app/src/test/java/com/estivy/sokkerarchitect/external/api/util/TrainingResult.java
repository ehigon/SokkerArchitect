package com.estivy.sokkerarchitect.external.api.util;

import com.estivy.sokkerarchitect.core.domain.TrainingType;


public class TrainingResult {

    private Long id;
    private TrainingType trainingType;
    private Integer officialMinutes;
    private Integer unofficialMinutes;
    private Integer trainerSkill;

    public TrainingResult() {
    }

    public TrainingResult(Long id, TrainingType trainingType, Integer officialMinutes,
                          Integer unofficialMinutes, Integer trainerSkill) {
        this.id = id;
        this.trainingType = trainingType;
        this.officialMinutes = officialMinutes;
        this.unofficialMinutes = unofficialMinutes;
        this.trainerSkill = trainerSkill;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public TrainingType getTrainingType() { return trainingType; }
    public void setTrainingType(TrainingType trainingType) { this.trainingType = trainingType; }

    public Integer getOfficialMinutes() { return officialMinutes; }
    public void setOfficialMinutes(Integer officialMinutes) { this.officialMinutes = officialMinutes; }

    public Integer getUnofficialMinutes() { return unofficialMinutes; }
    public void setUnofficialMinutes(Integer unofficialMinutes) { this.unofficialMinutes = unofficialMinutes; }

    public Integer getTrainerSkill() { return trainerSkill; }
    public void setTrainerSkill(Integer trainerSkill) { this.trainerSkill = trainerSkill; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long id;
        private TrainingType trainingType;
        private Integer officialMinutes;
        private Integer unofficialMinutes;
        private Integer trainerSkill;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder trainingType(TrainingType trainingType) { this.trainingType = trainingType; return this; }
        public Builder officialMinutes(Integer officialMinutes) { this.officialMinutes = officialMinutes; return this; }
        public Builder unofficialMinutes(Integer unofficialMinutes) { this.unofficialMinutes = unofficialMinutes; return this; }
        public Builder trainerSkill(Integer trainerSkill) { this.trainerSkill = trainerSkill; return this; }

        public TrainingResult build() {
            return new TrainingResult(id, trainingType, officialMinutes, unofficialMinutes, trainerSkill);
        }
    }
}
