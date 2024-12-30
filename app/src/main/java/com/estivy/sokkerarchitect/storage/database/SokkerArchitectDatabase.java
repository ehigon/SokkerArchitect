package com.estivy.sokkerarchitect.storage.database;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.estivy.sokkerarchitect.storage.entities.CountryEntity;
import com.estivy.sokkerarchitect.storage.entities.JuniorStatusEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerStatusEntity;
import com.estivy.sokkerarchitect.storage.repositories.CountryRepository;
import com.estivy.sokkerarchitect.storage.repositories.JuniorStatusRepository;
import com.estivy.sokkerarchitect.storage.repositories.PlayerRepository;
import com.estivy.sokkerarchitect.storage.repositories.PlayerStatusRepository;

@Database(entities = {PlayerEntity.class, PlayerStatusEntity.class, JuniorStatusEntity.class,
        CountryEntity.class},
        version = 2,
        exportSchema = false)
public abstract class SokkerArchitectDatabase extends RoomDatabase {

    public abstract PlayerRepository playerRepository();

    public abstract PlayerStatusRepository playerStatusRepository();

    public abstract JuniorStatusRepository juniorStatusRepository();

    public abstract CountryRepository countryRepository();
}
