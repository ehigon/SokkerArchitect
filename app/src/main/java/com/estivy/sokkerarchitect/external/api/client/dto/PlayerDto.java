package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

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

}
