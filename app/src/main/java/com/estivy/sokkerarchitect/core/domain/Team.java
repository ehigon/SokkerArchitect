package com.estivy.sokkerarchitect.core.domain;

import com.tickaroo.tikxml.annotation.PropertyElement;

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
public class Team {
    private Long teamId;
    private String name;
    private Integer countryId;
    private Integer regionId;
    private String dateCreated;
    private Double rank;
    private Integer national;
    private Integer colShirtKeep;
    private Integer colTrausKeep;
    private Integer colShirt;
    private Integer colTraus;
    private Integer colShirt2;
    private Integer colTraus2;
    private String arenaName;
    private Long money;
    private Integer fanclubCount;
    private Integer fanclubMood;
    private Integer juniorsMax;
    private Integer trainingTypeGk;
    private Integer trainingTypeDef;
    private Integer trainingTypeMid;
    private Integer trainingTypeAtt;
}
