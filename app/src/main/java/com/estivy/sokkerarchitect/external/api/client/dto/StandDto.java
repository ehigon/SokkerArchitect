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
@Xml(name = "stand")
public class StandDto {
    @PropertyElement
    private Integer location;
    @PropertyElement
    private String type;
    @PropertyElement
    private Integer size;
    @PropertyElement(name = "isRoof")
    private Integer roof;
    @PropertyElement
    private Integer constructionDays;
}
