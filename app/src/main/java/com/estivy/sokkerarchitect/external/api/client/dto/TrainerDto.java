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

}
