package com.estivy.sokkerarchitect.storage.conf;

import com.estivy.sokkerarchitect.SokkerArchitectApplication;
import com.estivy.sokkerarchitect.storage.mapper.CountryEntityMapper;
import com.estivy.sokkerarchitect.storage.mapper.PlayerEntityMapper;
import com.estivy.sokkerarchitect.storage.mapper.TeamEntityMapper;
import com.estivy.sokkerarchitect.storage.repositories.CountryRepository;
import com.estivy.sokkerarchitect.storage.repositories.JuniorStatusRepository;
import com.estivy.sokkerarchitect.storage.repositories.PlayerRepository;
import com.estivy.sokkerarchitect.storage.repositories.PlayerStatusRepository;
import com.estivy.sokkerarchitect.storage.repositories.TeamRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ViewModelComponent;

@Module
@InstallIn({ActivityComponent.class, ViewModelComponent.class})
public class StorageModule {

    @Provides
    public PlayerRepository playerRepository(){
        return SokkerArchitectApplication.database.playerRepository();
    }

    @Provides
    public PlayerStatusRepository playerStatusRepository(){
        return SokkerArchitectApplication.database.playerStatusRepository();
    }

    @Provides
    public JuniorStatusRepository juniorStatusRepository(){
        return SokkerArchitectApplication.database.juniorStatusRepository();
    }

    @Provides
    public CountryRepository countryRepository(){
        return SokkerArchitectApplication.database.countryRepository();
    }

    @Provides
    public TeamRepository teamRepository(){
        return SokkerArchitectApplication.database.teamRepository();
    }

    @Provides
    public PlayerEntityMapper providedPlayerMapper(){
        return PlayerEntityMapper.INSTANCE;
    }

    @Provides
    public CountryEntityMapper providedCountryMapper(){
        return CountryEntityMapper.INSTANCE;
    }

    @Provides
    public TeamEntityMapper providedTeamMapper(){
        return TeamEntityMapper.INSTANCE;
    }

}
