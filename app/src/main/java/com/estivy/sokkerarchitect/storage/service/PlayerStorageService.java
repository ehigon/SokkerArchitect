package com.estivy.sokkerarchitect.storage.service;

import com.estivy.sokkerarchitect.core.domain.Player;
import com.estivy.sokkerarchitect.storage.entities.JuniorStatusEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerStatusEntity;
import com.estivy.sokkerarchitect.storage.mapper.PlayerEntityMapper;
import com.estivy.sokkerarchitect.storage.relations.PlayerWithStatuses;
import com.estivy.sokkerarchitect.storage.relations.TeamWithCountry;
import com.estivy.sokkerarchitect.storage.repositories.JuniorStatusRepository;
import com.estivy.sokkerarchitect.storage.repositories.PlayerRepository;
import com.estivy.sokkerarchitect.storage.repositories.PlayerStatusRepository;
import com.estivy.sokkerarchitect.storage.repositories.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class PlayerStorageService {

    private final PlayerRepository playerRepository;

    private final PlayerStatusRepository playerStatusRepository;

    private final JuniorStatusRepository juniorStatusRepository;

    private final PlayerEntityMapper playerEntityMapper;

    private final TeamRepository teamRepository;

    @Inject
    public PlayerStorageService(PlayerRepository playerRepository, PlayerStatusRepository playerStatusRepository, JuniorStatusRepository juniorStatusRepository,
                                PlayerEntityMapper playerEntityMapper, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.playerStatusRepository = playerStatusRepository;
        this.juniorStatusRepository = juniorStatusRepository;
        this.playerEntityMapper = playerEntityMapper;
        this.teamRepository = teamRepository;
    }

    public List<Player> findSeniorActivePlayers() {
        List<PlayerWithStatuses> playerWithStatuses = playerRepository.findAllSeniorCompleteActive();
        TeamWithCountry team = teamRepository.findTeamWithcountry();
        return playerEntityMapper.mapToDomain(playerWithStatuses, team.getCountry());
    }

    public List<Player> findJuniorActivePlayers() {
        List<PlayerWithStatuses> playerWithStatuses = playerRepository.findAllJuniorCompleteActive();
        TeamWithCountry team = teamRepository.findTeamWithcountry();
        return playerEntityMapper.mapToDomain(playerWithStatuses, team.getCountry());
    }

    public void save(List<Player> players) {
        savePlayers(players);
        saveOrUpdateExistingPlayerStatuses(players);
        saveOrUpdateExistingJuniorStatuses(players);
        flagInactivePlayers(players);
    }

    private void savePlayers(List<Player> players) {
        playerRepository.save(playerEntityMapper.mapToEntity(players));
    }

    private void saveOrUpdateExistingPlayerStatuses(List<Player> players) {
        players.stream()
                .filter(p -> p.getPlayerStatuses() != null)
                .forEach(player -> {
                    saveOrUpdateExistingPlayerStatuses(player);
                    addExistingJuniorStatuses(player);
                });
    }

    private void saveOrUpdateExistingPlayerStatuses(Player player) {
        List<PlayerStatusEntity> newPlayerStatuses =
                playerEntityMapper.mapStatusToEntity(player.getPlayerStatuses(), player.getId());
        List<PlayerStatusEntity> playerStatuses = new ArrayList<>(
                playerStatusRepository.findAllPlayerStatusesByPlayerId(player.getId()));

        for (PlayerStatusEntity newPlayerStatusEntity : newPlayerStatuses) {
            Optional<PlayerStatusEntity> optExistingPlayerStatus
                    = findPlayerStatus(playerStatuses, newPlayerStatusEntity);
            playerStatuses.add(optExistingPlayerStatus
                    .map(p -> updatePlayerStatus(p, newPlayerStatusEntity))
                    .orElse(newPlayerStatusEntity));
        }
        playerStatusRepository.save(playerStatuses);
    }

    private void addExistingJuniorStatuses(Player player) {
        List<PlayerEntity> playerEntities = playerRepository.finAllByNameAndSurnameAndDistinctId(
                player.getName(), player.getSurname(), player.getId());
        for(PlayerEntity playerEntity : playerEntities) {
            List<JuniorStatusEntity> juniorStatusEntities = juniorStatusRepository.
                    findAllJuniorStatusesByPlayerId(playerEntity.getId());
            System.out.println("Updating " + juniorStatusEntities.size() + " junior statuses for player " + player.getName() + " " + player.getSurname() );
            juniorStatusEntities.forEach(j -> j.setPlayerId(player.getId()));
            juniorStatusRepository.save(juniorStatusEntities);
            playerRepository.deleteById(playerEntity.getId());
        }
    }

    private void saveOrUpdateExistingJuniorStatuses(List<Player> players) {
        players.stream()
                .filter(p -> p.getJuniorStatuses() != null)
                .forEach(this::saveOrUpdateExistingJuniorStatuses);
    }

    private void saveOrUpdateExistingJuniorStatuses(Player player) {
        List<JuniorStatusEntity> newJuniorStatuses =
                playerEntityMapper.mapJuniorStatusToEntity(player.getJuniorStatuses(), player.getId());
        List<JuniorStatusEntity> juniorStatuses = new ArrayList<>(
                juniorStatusRepository.findAllJuniorStatusesByPlayerId(player.getId()));

        for (JuniorStatusEntity newJuniorStatus : newJuniorStatuses) {
            Optional<JuniorStatusEntity> optExistingPlayerStatus
                    = findJuniorStatus(juniorStatuses, newJuniorStatus);
            juniorStatuses.add(optExistingPlayerStatus
                    .map(j -> updateJuniorStatus(j, newJuniorStatus))
                    .orElse(newJuniorStatus));
        }
        juniorStatusRepository.save(juniorStatuses);
    }

    private Optional<PlayerStatusEntity> findPlayerStatus(List<PlayerStatusEntity> playerStatuses,
                                                          PlayerStatusEntity playerStatusEntity) {
        return playerStatuses.stream()
                .filter(p -> p.getWeek().equals(playerStatusEntity.getWeek()))
                .findFirst();
    }

    private Optional<JuniorStatusEntity> findJuniorStatus(List<JuniorStatusEntity> juniorStatuses,
                                                          JuniorStatusEntity newJuniorStatus) {
        return juniorStatuses.stream()
                .filter(j -> j.getWeek().equals(newJuniorStatus.getWeek()))
                .findFirst();
    }

    private PlayerStatusEntity updatePlayerStatus(PlayerStatusEntity existingPlayerStatus,
                                                  PlayerStatusEntity newPlayerStatus) {
        existingPlayerStatus.setSkillForm(newPlayerStatus.getSkillForm());
        existingPlayerStatus.setTransferList(newPlayerStatus.getTransferList());
        return existingPlayerStatus;
    }

    private JuniorStatusEntity updateJuniorStatus(JuniorStatusEntity existingJuniorStatus,
                                                  JuniorStatusEntity newJuniorStatus) {
        existingJuniorStatus.setFormation(newJuniorStatus.getFormation());
        existingJuniorStatus.setSkill(newJuniorStatus.getSkill());
        existingJuniorStatus.setRemainingWeeks(newJuniorStatus.getRemainingWeeks());
        return existingJuniorStatus;
    }

    private void flagInactivePlayers(List<Player> players) {
        List<PlayerEntity> playerEntities = playerRepository.findAllActive();
        List<PlayerEntity> playerEntitiesToUpdate = playerEntities.stream()
                .filter(p -> !existsInUpdate(p, players))
                .collect(Collectors.toList());
        if (playerEntitiesToUpdate.isEmpty()) {
            return;
        }
        playerEntitiesToUpdate.forEach(p -> p.setActive(false));
        playerRepository.save(playerEntitiesToUpdate);
    }

    private boolean existsInUpdate(PlayerEntity playerEntity, List<Player> players) {
        return players.stream()
                .anyMatch(p -> p.getId().equals(playerEntity.getId()));
    }

}
