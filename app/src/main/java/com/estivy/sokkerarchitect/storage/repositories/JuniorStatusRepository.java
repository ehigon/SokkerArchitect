package com.estivy.sokkerarchitect.storage.repositories;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.estivy.sokkerarchitect.storage.entities.JuniorStatusEntity;

import java.util.List;

@Dao
public interface JuniorStatusRepository {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(List<JuniorStatusEntity> juniorStatusEntities);

    @Query("SELECT * FROM junior_statuses")
    List<JuniorStatusEntity> findAllJuniorStatuses();

    @Query("SELECT * FROM junior_statuses WHERE junior_statuses.playerId = :playerId")
    List<JuniorStatusEntity> findAllJuniorStatusesByPlayerId(Long playerId);
}
