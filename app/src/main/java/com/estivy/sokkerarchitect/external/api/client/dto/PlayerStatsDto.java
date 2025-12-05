package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.Attribute;
import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml(name = "playerStat")
public class PlayerStatsDto {

    @Attribute(name = "teamID")
    private Long teamId;
    @Element
    private List<PlayerStatDto> playerStat;

    public PlayerStatsDto() {}

    public PlayerStatsDto(Long teamId, List<PlayerStatDto> playerStat) {
        this.teamId = teamId;
        this.playerStat = playerStat;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public List<PlayerStatDto> getPlayerStat() {
        return playerStat;
    }

    public void setPlayerStat(List<PlayerStatDto> playerStat) {
        this.playerStat = playerStat;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long teamId;
        private List<PlayerStatDto> playerStat;

        public Builder teamId(Long teamId) {
            this.teamId = teamId;
            return this;
        }

        public Builder playerStat(List<PlayerStatDto> playerStat) {
            this.playerStat = playerStat;
            return this;
        }

        public PlayerStatsDto build() {
            return new PlayerStatsDto(teamId, playerStat);
        }
    }
}
