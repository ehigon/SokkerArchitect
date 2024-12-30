package com.estivy.sokkerarchitect.external.api.client.conf;

import com.estivy.sokkerarchitect.external.api.client.SokkerAPI;
import com.estivy.sokkerarchitect.external.api.client.mapper.PlayerMapper;
import com.estivy.sokkerarchitect.external.api.client.mapper.TeamMapper;
import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
@InstallIn(ActivityComponent.class)
public class SokkerClientModule {

    @Provides
    public SokkerAPI provideSokkerAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://sokker.org/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(TikXmlConverterFactory.create(
                        new TikXml.Builder()
                                .exceptionOnUnreadXml(false)
                                .build()))
                .build();

        return retrofit.create(SokkerAPI.class);
    }

    @Provides
    public PlayerMapper providedPlayerMapper(){
        return PlayerMapper.INSTANCE;
    }

    @Provides
    public TeamMapper providedTeamMapper(){
        return TeamMapper.INSTANCE;
    }

}
