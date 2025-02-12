package com.estivy.sokkerarchitect.core.service;

import com.estivy.sokkerarchitect.core.domain.Player;
import com.estivy.sokkerarchitect.storage.service.PlayerStorageService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

public class PlayersService {

    private final PlayerStorageService playerStorageService;


    @Inject
    public PlayersService(PlayerStorageService playerStorageService) {
        this.playerStorageService = playerStorageService;
    }

    public List<Player> findPlayers(){
        return playerStorageService.findSeniorActivePlayers();
    }

    @NotNull
    public List<Player> findJuniors() {
        return playerStorageService.findJuniorActivePlayers();
    }

    public List<Player> findAll() {
        return playerStorageService.findAll();
    }

    public void save(List<Player> players){
        playerStorageService.save(players);
    }

    public void saveNotes(Long id, String notes) {
        playerStorageService.saveNotes(id, notes);
    }
}
