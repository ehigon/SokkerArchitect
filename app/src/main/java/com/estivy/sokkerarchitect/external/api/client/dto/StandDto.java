package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

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
    private Double constructionDays;

    public StandDto() {
    }

    public StandDto(Integer location, String type, Integer size, Integer roof, Double constructionDays) {
        this.location = location;
        this.type = type;
        this.size = size;
        this.roof = roof;
        this.constructionDays = constructionDays;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getRoof() {
        return roof;
    }

    public void setRoof(Integer roof) {
        this.roof = roof;
    }

    public Double getConstructionDays() {
        return constructionDays;
    }

    public void setConstructionDays(Double constructionDays) {
        this.constructionDays = constructionDays;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer location;
        private String type;
        private Integer size;
        private Integer roof;
        private Double constructionDays;

        public Builder location(Integer location) {
            this.location = location;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder size(Integer size) {
            this.size = size;
            return this;
        }

        public Builder roof(Integer roof) {
            this.roof = roof;
            return this;
        }

        public Builder constructionDays(Double constructionDays) {
            this.constructionDays = constructionDays;
            return this;
        }

        public StandDto build() {
            return new StandDto(location, type, size, roof, constructionDays);
        }
    }
}
