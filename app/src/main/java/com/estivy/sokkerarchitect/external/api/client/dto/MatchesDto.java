package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml
public class MatchesDto {
    @Element
    private List<MatchDto> matches;

    public MatchesDto() {
    }

    public MatchesDto(List<MatchDto> matches) {
        this.matches = matches;
    }

    public List<MatchDto> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDto> matches) {
        this.matches = matches;
    }
}
