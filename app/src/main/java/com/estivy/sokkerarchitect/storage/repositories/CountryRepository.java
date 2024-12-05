package com.estivy.sokkerarchitect.storage.repositories;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.estivy.sokkerarchitect.storage.entities.CountryEntity;

import java.util.List;

@Dao
public interface CountryRepository {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(List<CountryEntity> countries);
}
