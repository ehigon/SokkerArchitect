package com.estivy.sokkerarchitect.core.domain;

public class Country {

    private Integer countryId;

    private String name;

    private String currencyName;

    private Double currencyRate;

    public Country() {
    }

    public Country(Integer countryId, String name, String currencyName, Double currencyRate) {
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

    public static CountryBuilder builder() {
        return new CountryBuilder();
    }

    public static class CountryBuilder {
        private Integer countryId;
        private String name;
        private String currencyName;
        private Double currencyRate;

        public CountryBuilder countryId(Integer countryId) {
            this.countryId = countryId;
            return this;
        }

        public CountryBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CountryBuilder currencyName(String currencyName) {
            this.currencyName = currencyName;
            return this;
        }

        public CountryBuilder currencyRate(Double currencyRate) {
            this.currencyRate = currencyRate;
            return this;
        }

        public Country build() {
            return new Country(countryId, name, currencyName, currencyRate);
        }
    }
}
