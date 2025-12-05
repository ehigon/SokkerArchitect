package com.estivy.sokkerarchitect.storage.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "countries")
public class CountryEntity {

    @PrimaryKey
    private Integer countryId;

    private String name;

    private String currencyName;

    private Double currencyRate;

    public CountryEntity() {
    }

    @Ignore
    public CountryEntity(Integer countryId, String name, String currencyName, Double currencyRate) {
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer countryId;
        private String name;
        private String currencyName;
        private Double currencyRate;

        public Builder countryId(Integer countryId) { this.countryId = countryId; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder currencyName(String currencyName) { this.currencyName = currencyName; return this; }
        public Builder currencyRate(Double currencyRate) { this.currencyRate = currencyRate; return this; }

        public CountryEntity build() {
            return new CountryEntity(countryId, name, currencyName, currencyRate);
        }
    }
}
