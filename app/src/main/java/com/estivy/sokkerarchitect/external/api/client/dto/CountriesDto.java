package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;


@Xml
public class CountriesDto {
    @Element
    private List<CountryDto> countries;

    public CountriesDto() {
    }

    public CountriesDto(List<CountryDto> countries) {
        this.countries = countries;
    }

    public List<CountryDto> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryDto> countries) {
        this.countries = countries;
    }

}
