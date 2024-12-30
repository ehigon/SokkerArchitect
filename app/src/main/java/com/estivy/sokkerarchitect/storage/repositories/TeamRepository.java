package com.estivy.sokkerarchitect.storage.repositories;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.estivy.sokkerarchitect.storage.entities.TeamEntity;
import com.estivy.sokkerarchitect.storage.relations.TeamWithCountry;

@Dao
public interface TeamRepository {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(TeamEntity team);

    @Query("SELECT * FROM team")
    TeamEntity findTeam();

    @Transaction
    @Query("SELECT * FROM team")
    TeamWithCountry findTeamWithcountry();
}
