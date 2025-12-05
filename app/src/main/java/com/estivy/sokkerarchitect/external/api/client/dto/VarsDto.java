package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

@Xml
public class VarsDto {
    @PropertyElement
    private Long week;
    @PropertyElement
    private Integer day;

    public VarsDto() {
    }

    public VarsDto(Long week, Integer day) {
        this.week = week;
        this.day = day;
    }

    public Long getWeek() {
        return week;
    }

    public void setWeek(Long week) {
        this.week = week;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long week;
        private Integer day;

        public Builder week(Long week) {
            this.week = week;
            return this;
        }

        public Builder day(Integer day) {
            this.day = day;
            return this;
        }

        public VarsDto build() {
            return new VarsDto(week, day);
        }
    }
}
