package com.estivy.sokkerarchitect.core.service;

import com.estivy.sokkerarchitect.core.domain.Player;
import com.estivy.sokkerarchitect.storage.service.PlayerStorageService;

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
}
