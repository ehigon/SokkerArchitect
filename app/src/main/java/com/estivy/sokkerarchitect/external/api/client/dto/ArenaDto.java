package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;


@Xml(name = "arena")
public class ArenaDto {
    @Element
    private List<StandDto> stand;

    public ArenaDto() {
    }

    public ArenaDto(List<StandDto> stand) {
        this.stand = stand;
    }

    public List<StandDto> getStand() {
        return stand;
    }

    public void setStand(List<StandDto> stand) {
        this.stand = stand;
    }
}
