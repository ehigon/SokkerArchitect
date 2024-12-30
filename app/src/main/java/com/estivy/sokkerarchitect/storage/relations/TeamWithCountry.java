package com.estivy.sokkerarchitect.storage.relations;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;

import com.estivy.sokkerarchitect.storage.entities.CountryEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerEntity;
import com.estivy.sokkerarchitect.storage.entities.TeamEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(onConstructor_=@__({@Ignore}))
public class TeamWithCountry {
    @Embedded
    private TeamEntity team;
    @Relation(
            parentColumn = "countryId",
            entityColumn = "countryId"
    )
    private CountryEntity country;
}
