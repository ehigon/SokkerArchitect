package com.estivy.sokkerarchitect.storage.repositories;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.estivy.sokkerarchitect.storage.entities.PlayerEntity;
import com.estivy.sokkerarchitect.storage.relations.PlayerWithStatuses;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

@Dao
public interface PlayerRepository {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(List<PlayerEntity> players);

    @Query("SELECT * FROM players WHERE active = 1")
    List<PlayerEntity> findAllActive();

    @Transaction
    @Query("SELECT * FROM players")
    List<PlayerWithStatuses> findAllComplete();

    @Transaction
    @Query("SELECT * FROM players WHERE active = 1 " +
            "and (SELECT COUNT(*) " +
            "from player_statuses where player_statuses.playerId = players.id) > 0")
    List<PlayerWithStatuses> findAllSeniorCompleteActive();

    @Transaction
    @Query("SELECT * FROM players WHERE active = 1 " +
            "and (SELECT COUNT(*) " +
            "from player_statuses where player_statuses.playerId = players.id) = 0")
    List<PlayerWithStatuses> findAllJuniorCompleteActive();


}
