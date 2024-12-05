package com.estivy.sokkerarchitect.external.api.util;

import com.estivy.sokkerarchitect.core.domain.TrainingType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingResult {

    private Long id;
    private TrainingType trainingType;
    private Integer officialMinutes;
    private Integer unofficialMinutes;
    private Integer trainerSkill;

}
