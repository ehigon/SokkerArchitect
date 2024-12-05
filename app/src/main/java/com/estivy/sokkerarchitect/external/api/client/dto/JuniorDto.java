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
@Xml(name = "junior")
public class JuniorDto {
    @PropertyElement(name = "ID")
    private Long id;
    @PropertyElement
    private String name;
    @PropertyElement
    private String surname;
    @PropertyElement
    private Integer age;
    @PropertyElement
    private Integer height;
    @PropertyElement
    private Double weight;
    @PropertyElement(name = "BMI")
    private Double bmi;
    @PropertyElement
    private Integer skill;
    @PropertyElement
    private Integer formation;
    @PropertyElement
    private Integer weeks;
}
