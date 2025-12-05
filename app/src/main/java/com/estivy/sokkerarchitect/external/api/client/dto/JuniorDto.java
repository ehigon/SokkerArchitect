package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

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

    public JuniorDto() {
    }

    public JuniorDto(Long id, String name, String surname, Integer age, Integer height, Double weight, Double bmi, Integer skill, Integer formation, Integer weeks) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.skill = skill;
        this.formation = formation;
        this.weeks = weeks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public Integer getFormation() {
        return formation;
    }

    public void setFormation(Integer formation) {
        this.formation = formation;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }
}
