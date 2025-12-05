package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

@Xml
public class TeamDataDto {
    @Element
    private TeamDto team;
    @Element
    private ArenaDto arena;
    @Element
    private UserDto user;

    public TeamDataDto() {
    }

    public TeamDataDto(TeamDto team, ArenaDto arena, UserDto user) {
        this.team = team;
        this.arena = arena;
        this.user = user;
    }

    public TeamDto getTeam() {
        return team;
    }

    public void setTeam(TeamDto team) {
        this.team = team;
    }

    public ArenaDto getArena() {
        return arena;
    }

    public void setArena(ArenaDto arena) {
        this.arena = arena;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private TeamDto team;
        private ArenaDto arena;
        private UserDto user;

        public Builder team(TeamDto team) {
            this.team = team;
            return this;
        }

        public Builder arena(ArenaDto arena) {
            this.arena = arena;
            return this;
        }

        public Builder user(UserDto user) {
            this.user = user;
            return this;
        }

        public TeamDataDto build() {
            return new TeamDataDto(team, arena, user);
        }
    }
}
