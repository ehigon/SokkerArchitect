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
@Xml(name = "playerStats")
public class PlayerStatDto {
    @PropertyElement(name = "playerID")
    private Long playerId;
    @PropertyElement
    private Integer number;
    @PropertyElement
    private Integer formation;
    @PropertyElement
    private Integer timeIn;
    @PropertyElement
    private Integer timeOut;
    @PropertyElement
    private Integer yellowCards;
    @PropertyElement
    private Integer redCards;
    @PropertyElement(name = "isInjured")
    private Integer injured;
    @PropertyElement
    private Integer goals;
    @PropertyElement
    private Integer assists;
    @PropertyElement
    private Integer fouls;
    @PropertyElement
    private Integer shoots;
    @PropertyElement
    private Integer rating;
    @PropertyElement
    private Integer timePlaying;
    @PropertyElement
    private Integer timeDefending;
}
