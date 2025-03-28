package com.estivy.sokkerarchitect.storage.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.estivy.sokkerarchitect.storage.entities.CountryEntity;
import com.estivy.sokkerarchitect.storage.entities.JuniorStatusEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerStatusEntity;
import com.estivy.sokkerarchitect.storage.entities.TeamEntity;
import com.estivy.sokkerarchitect.storage.repositories.CountryRepository;
import com.estivy.sokkerarchitect.storage.repositories.JuniorStatusRepository;
import com.estivy.sokkerarchitect.storage.repositories.PlayerRepository;
import com.estivy.sokkerarchitect.storage.repositories.PlayerStatusRepository;
import com.estivy.sokkerarchitect.storage.repositories.TeamRepository;

@Database(entities = {PlayerEntity.class, PlayerStatusEntity.class, JuniorStatusEntity.class,
        CountryEntity.class, TeamEntity.class},
        version = 4,
        exportSchema = false)
public abstract class SokkerArchitectDatabase extends RoomDatabase {

    public abstract PlayerRepository playerRepository();

    public abstract PlayerStatusRepository playerStatusRepository();

    public abstract JuniorStatusRepository juniorStatusRepository();

    public abstract CountryRepository countryRepository();

    public abstract TeamRepository teamRepository();
}
