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
@Xml(name = "teamStats")
public class TeamStatsDto {

    @PropertyElement(name = "teamID")
    private Long teamId;
    @PropertyElement
    private Integer timeOnHalf;
    @PropertyElement
    private Integer timePossession;
    @PropertyElement
    private Integer offsides;
    @PropertyElement
    private Integer shoots;
    @PropertyElement
    private Integer fouls;
    @PropertyElement
    private Integer yellowCards;
    @PropertyElement
    private Integer redCards;
    @PropertyElement
    private String tacticName;
    @PropertyElement
    private Integer ratingScoring;
    @PropertyElement
    private Integer ratingPassing;
    @PropertyElement
    private Integer ratingDefending;

}
