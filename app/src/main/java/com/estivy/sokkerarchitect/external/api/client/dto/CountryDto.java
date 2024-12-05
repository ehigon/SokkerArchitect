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
@Xml(name = "country")
public class CountryDto {
    @PropertyElement(name = "countryID")
    private Integer countryId;
    @PropertyElement
    private String name;
    @PropertyElement
    private String currencyName;
    @PropertyElement
    private Double currencyRate;
}
