package com.estivy.sokkerarchitect.security.service;

import static com.estivy.sokkerarchitect.util.FileMapperUtil.mapJsonFileToClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.util.Pair;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.estivy.sokkerarchitect.core.domain.Country;
import com.estivy.sokkerarchitect.core.domain.JuniorStatus;
import com.estivy.sokkerarchitect.core.domain.Player;
import com.estivy.sokkerarchitect.core.domain.PlayerStatus;
import com.estivy.sokkerarchitect.storage.database.SokkerArchitectDatabase;
import com.estivy.sokkerarchitect.storage.entities.CountryEntity;
import com.estivy.sokkerarchitect.storage.entities.JuniorStatusEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerStatusEntity;
import com.estivy.sokkerarchitect.storage.mapper.PlayerEntityMapper;
import com.estivy.sokkerarchitect.storage.relations.PlayerWithStatuses;
import com.estivy.sokkerarchitect.storage.repositories.CountryRepository;
import com.estivy.sokkerarchitect.storage.repositories.JuniorStatusRepository;
import com.estivy.sokkerarchitect.storage.repositories.PlayerRepository;
import com.estivy.sokkerarchitect.storage.repositories.PlayerStatusRepository;
import com.estivy.sokkerarchitect.storage.service.PlayerStorageService;
import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RunWith(AndroidJUnit4.class)
public class PasswordStorageServiceIT {

    private final PasswordStorageService passwordStorageService = new PasswordStorageService();

    @Test
    public void given_credentials_when_save_then_credentialsAreSaved() {
        Pair<String, String> originCredentials = Pair.create("user", "password");

        passwordStorageService.setCredentials(originCredentials);

        Pair<String, String> recoveredCredentials = passwordStorageService.getCredentials();
        assertEquals(originCredentials, recoveredCredentials);
    }

}
