package com.estivy.sokkerarchitect.core.service;

import android.util.Pair;

import com.estivy.sokkerarchitect.core.domain.Status;
import com.estivy.sokkerarchitect.external.api.service.UpdateRetrievalService;
import com.estivy.sokkerarchitect.security.service.PasswordStorageService;
import com.estivy.sokkerarchitect.storage.service.CountryStorageService;
import com.estivy.sokkerarchitect.storage.service.PlayerStorageService;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

public class UpdateService {

    private final UpdateRetrievalService updateRetrievalService;

    private final PlayerStorageService playerStorageService;

    private final CountryStorageService countryStorageService;

    private final PasswordStorageService passwordStorageService;

    @Inject
    public UpdateService(UpdateRetrievalService updateRetrievalService, PlayerStorageService storeService, CountryStorageService countryStorageService, PasswordStorageService passwordStorageService) {
        this.updateRetrievalService = updateRetrievalService;
        this.playerStorageService = storeService;
        this.countryStorageService = countryStorageService;
        this.passwordStorageService = passwordStorageService;
    }

    public CompletableFuture<Void> update() {
        Pair<String, String> credentials = passwordStorageService.getCredentials();
        return doUpdate(credentials.first, credentials.second);
    }

    public CompletableFuture<Void> update(String login, String password) {
        return doUpdate(login, password)
                .thenApply(nothing -> {
                    passwordStorageService.setCredentials(Pair.create(login, password));
                    return null;
                });
    }

    private CompletableFuture<Void> doUpdate(String login, String password) {
        return CompletableFuture.supplyAsync(() -> {
            Status status = updateRetrievalService.getUpdate(login, password);
            countryStorageService.saveCountries(status.getCountries());
            playerStorageService.save(status.getPlayers());
            return null;
        });
    }

}
