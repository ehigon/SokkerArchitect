package com.estivy.sokkerarchitect.storage.relations;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;

import com.estivy.sokkerarchitect.storage.entities.CountryEntity;
import com.estivy.sokkerarchitect.storage.entities.JuniorStatusEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerStatusEntity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(onConstructor_=@__({@Ignore}))
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
}
