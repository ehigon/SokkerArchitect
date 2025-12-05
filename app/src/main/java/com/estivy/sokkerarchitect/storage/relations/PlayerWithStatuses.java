package com.estivy.sokkerarchitect.storage.relations;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;

import com.estivy.sokkerarchitect.storage.entities.CountryEntity;
import com.estivy.sokkerarchitect.storage.entities.JuniorStatusEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerStatusEntity;

import java.util.List;

public class PlayerWithStatuses {
    @Embedded
    private PlayerEntity player;
    @Relation(
            parentColumn = "id",
            entityColumn = "playerId"
    )
    private List<PlayerStatusEntity> playerStatuses;
    @Relation(
            parentColumn = "id",
            entityColumn = "playerId"
    )
    private List<JuniorStatusEntity> juniorStatuses;
    @Relation(
            parentColumn = "countryId",
            entityColumn = "countryId"
    )
    private CountryEntity country;

    public PlayerWithStatuses() {
    }

    @Ignore
    public PlayerWithStatuses(PlayerEntity player, List<PlayerStatusEntity> playerStatuses,
                              List<JuniorStatusEntity> juniorStatuses, CountryEntity country) {
        this.player = player;
        this.playerStatuses = playerStatuses;
        this.juniorStatuses = juniorStatuses;
        this.country = country;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public List<PlayerStatusEntity> getPlayerStatuses() {
        return playerStatuses;
    }

    public void setPlayerStatuses(List<PlayerStatusEntity> playerStatuses) {
        this.playerStatuses = playerStatuses;
    }

    public List<JuniorStatusEntity> getJuniorStatuses() {
        return juniorStatuses;
    }

    public void setJuniorStatuses(List<JuniorStatusEntity> juniorStatuses) {
        this.juniorStatuses = juniorStatuses;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PlayerEntity player;
        private List<PlayerStatusEntity> playerStatuses;
        private List<JuniorStatusEntity> juniorStatuses;
        private CountryEntity country;

        public Builder player(PlayerEntity player) { this.player = player; return this; }
        public Builder playerStatuses(List<PlayerStatusEntity> playerStatuses) { this.playerStatuses = playerStatuses; return this; }
        public Builder juniorStatuses(List<JuniorStatusEntity> juniorStatuses) { this.juniorStatuses = juniorStatuses; return this; }
        public Builder country(CountryEntity country) { this.country = country; return this; }

        public PlayerWithStatuses build() {
            return new PlayerWithStatuses(player, playerStatuses, juniorStatuses, country);
        }
    }
}
