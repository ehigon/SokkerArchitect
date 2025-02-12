package com.estivy.sokkerarchitect.storage.repositories;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.estivy.sokkerarchitect.storage.entities.PlayerEntity;
import com.estivy.sokkerarchitect.storage.relations.PlayerWithStatuses;

import java.util.List;

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

    @Query("SELECT * FROM players WHERE name = :name AND surname = :surname AND id != :id")
    List<PlayerEntity> finAllByNameAndSurnameAndDistinctId(String name, String surname, Long id);

    @Query("DELETE FROM players WHERE id = :id")
    void deleteById(Long id);

    @Query("SELECT * FROM players WHERE id = :id")
    List<PlayerEntity> findById(Long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(PlayerEntity player);

    @Query("DELETE FROM players " +
            "WHERE (SELECT COUNT(*) from player_statuses " +
                "where player_statuses.playerId = players.id) = 0 " +
            "AND (SELECT COUNT(*) from junior_statuses " +
                "where junior_statuses.playerId = players.id) = 0")
    void deleteOrphanedPlayers();

    @Query("SELECT * FROM players WHERE id in (:ids)")
    List<PlayerEntity> findByIds(List<Long> ids);

    @Query("UPDATE players SET notes = :notes WHERE id = :id")
    void updateNotes(Long id, String notes);
}
