package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.PropertyElement;
import com.tickaroo.tikxml.annotation.Xml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Xml(name = "match")
public class MatchDto {

    @PropertyElement(name = "matchID")
    private Long matchId;
    @PropertyElement(name = "homeTeamID")
    private Long homeTeamId;
    @PropertyElement(name = "awayTeamID")
    private Long awayTeamId;
    @PropertyElement
    private String homeTeamName;
    @PropertyElement
    private String awayTeamName;
    @PropertyElement(name = "leagueID")
    private Long leagueId;
    @PropertyElement
    private Integer round;
    @PropertyElement
    private Integer season;
    @PropertyElement
    private Long week;
    @PropertyElement
    private Integer day;
    @PropertyElement
    private String dateExpected;
    @PropertyElement
    private String dateStarted;
    @PropertyElement
    private Integer homeTeamScore;
    @PropertyElement
    private Integer awayTeamScore;
    @PropertyElement
    private Integer supporters;
    @PropertyElement
    private Integer weather;
    @PropertyElement(name = "isFinished")
    private Integer finished;
}
