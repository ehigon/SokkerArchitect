package com.estivy.sokkerarchitect.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
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
}
