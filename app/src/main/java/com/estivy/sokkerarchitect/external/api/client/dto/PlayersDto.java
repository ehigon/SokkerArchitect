package com.estivy.sokkerarchitect.external.api.client.dto;

import com.tickaroo.tikxml.annotation.Element;
import com.tickaroo.tikxml.annotation.Xml;

import java.util.List;

@Xml
public class PlayersDto {
    @Element
    private List<PlayerDto> players;

    public PlayersDto() {
    }

    public PlayersDto(List<PlayerDto> players) {
        this.players = players;
    }

    public List<PlayerDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDto> players) {
        this.players = players;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<PlayerDto> players;

        public Builder players(List<PlayerDto> players) {
            this.players = players;
            return this;
        }

        public PlayersDto build() {
            return new PlayersDto(players);
        }
    }
}
