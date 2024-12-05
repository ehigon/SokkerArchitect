package com.estivy.sokkerarchitect.storage.repositories;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.estivy.sokkerarchitect.storage.entities.PlayerStatusEntity;

import java.util.List;

@Dao
public interface PlayerStatusRepository {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(List<PlayerStatusEntity> playerStatuses);

    @Query("SELECT * FROM player_statuses")
    List<PlayerStatusEntity> findAllPlayerStatuses();

    @Query("SELECT * FROM player_statuses WHERE player_statuses.playerId = :playerId")
    List<PlayerStatusEntity> findAllPlayerStatusesByPlayerId(Long playerId);
}
