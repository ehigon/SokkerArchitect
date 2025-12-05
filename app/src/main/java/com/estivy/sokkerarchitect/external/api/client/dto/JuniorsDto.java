package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml
public class JuniorsDto {
    @Element
    private List<JuniorDto> juniors;

    public JuniorsDto() {
    }

    public JuniorsDto(List<JuniorDto> juniors) {
        this.juniors = juniors;
    }

    public List<JuniorDto> getJuniors() {
        return juniors;
    }

    public void setJuniors(List<JuniorDto> juniors) {
        this.juniors = juniors;
    }
}
