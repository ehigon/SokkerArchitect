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
@Xml(name = "team")
public class TeamDto {
    @PropertyElement(name = "teamID")
    private Long teamId;
    @PropertyElement
    private String name;
    @PropertyElement(name = "countryID")
    private Integer countryId;
    @PropertyElement(name = "regionID")
    private Integer regionId;
    @PropertyElement
    private String dateCreated;
    @PropertyElement
    private Double rank;
    @PropertyElement
    private Integer national;
    @PropertyElement
    private Integer colShirtKeep;
    @PropertyElement
    private Integer colTrausKeep;
    @PropertyElement
    private Integer colShirt;
    @PropertyElement
    private Integer colTraus;
    @PropertyElement
    private Integer colShirt2;
    @PropertyElement
    private Integer colTraus2;
    @PropertyElement
    private String arenaName;
    @PropertyElement
    private Long money;
    @PropertyElement
    private Integer trainingType;
    @PropertyElement
    private Integer trainingFormation;
    @PropertyElement
    private Integer fanclubCount;
    @PropertyElement
    private Integer fanclubMood;
    @PropertyElement
    private Integer juniorsMax;
    @PropertyElement
    private Integer trainingTypeGk;
    @PropertyElement
    private Integer trainingTypeDef;
    @PropertyElement
    private Integer trainingTypeMid;
    @PropertyElement
    private Integer trainingTypeAtt;
}
