package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;


@Xml
public class MatchDetailDto {

    @Element
    private MatchInfoDto info;
    @Element(name = "teamStats")
    private List<TeamStatsDto> teamStats;
    @Element(name = "playersStats")
    private List<PlayerStatsDto> playerStats;

    public MatchDetailDto() {
    }

    public MatchDetailDto(MatchInfoDto info,
                          List<TeamStatsDto> teamStats,
                          List<PlayerStatsDto> playerStats) {
        this.info = info;
        this.teamStats = teamStats;
        this.playerStats = playerStats;
    }

    public MatchInfoDto getInfo() {
        return info;
    }

    public void setInfo(MatchInfoDto info) {
        this.info = info;
    }

    public List<TeamStatsDto> getTeamStats() {
        return teamStats;
    }

    public void setTeamStats(List<TeamStatsDto> teamStats) {
        this.teamStats = teamStats;
    }

    public List<PlayerStatsDto> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(List<PlayerStatsDto> playerStats) {
        this.playerStats = playerStats;
    }

    public static MatchDetailDtoBuilder builder() {
        return new MatchDetailDtoBuilder();
    }

    public static class MatchDetailDtoBuilder {

        private MatchInfoDto info;
        private List<TeamStatsDto> teamStats;
        private List<PlayerStatsDto> playerStats;

        MatchDetailDtoBuilder() {
        }

        public MatchDetailDtoBuilder info(MatchInfoDto info) {
            this.info = info;
            return this;
        }

        public MatchDetailDtoBuilder teamStats(List<TeamStatsDto> teamStats) {
            this.teamStats = teamStats;
            return this;
        }

        public MatchDetailDtoBuilder playerStats(List<PlayerStatsDto> playerStats) {
            this.playerStats = playerStats;
            return this;
        }

        public MatchDetailDto build() {
            return new MatchDetailDto(info, teamStats, playerStats);
        }

        @Override
        public String toString() {
            return "MatchDetailDto.MatchDetailDtoBuilder(" +
                    "info=" + info +
                    ", teamStats=" + teamStats +
                    ", playerStats=" + playerStats +
                    ")";
        }
    }
}
