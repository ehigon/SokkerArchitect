package com.estivy.sokkerarchitect.storage.relations;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;

import com.estivy.sokkerarchitect.storage.entities.CountryEntity;
import com.estivy.sokkerarchitect.storage.entities.TeamEntity;

public class TeamWithCountry {
    @Embedded
    private TeamEntity team;
    @Relation(
            parentColumn = "countryId",
            entityColumn = "countryId"
    )
    private CountryEntity country;

    public TeamWithCountry() {
    }

    @Ignore
    public TeamWithCountry(TeamEntity team, CountryEntity country) {
        this.team = team;
        this.country = country;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
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
        private TeamEntity team;
        private CountryEntity country;

        public Builder team(TeamEntity team) { this.team = team; return this; }
        public Builder country(CountryEntity country) { this.country = country; return this; }

        public TeamWithCountry build() {
            return new TeamWithCountry(team, country);
        }
    }
}
