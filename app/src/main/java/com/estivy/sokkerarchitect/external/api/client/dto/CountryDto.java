package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

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

    public CountryDto() {
    }

    public CountryDto(Integer countryId, String name, String currencyName, Double currencyRate) {
        this.countryId = countryId;
        this.name = name;
        this.currencyName = currencyName;
        this.currencyRate = currencyRate;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(Double currencyRate) {
        this.currencyRate = currencyRate;
    }

}
