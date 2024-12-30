package com.estivy.sokkerarchitect.storage;

import static com.estivy.sokkerarchitect.util.FileMapperUtil.mapJsonFileToClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;

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
public class PlayerStorageServiceIT {

    private SokkerArchitectDatabase db;

    private PlayerRepository playerRepository;

    private PlayerStorageService playerStorageService;

    @Before
    public void createDb() throws IOException {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, SokkerArchitectDatabase.class).build();
        playerRepository = db.playerRepository();
        PlayerStatusRepository playerStatusRepository = db.playerStatusRepository();
        JuniorStatusRepository juniorStatusRepository = db.juniorStatusRepository();
        playerStorageService = new PlayerStorageService(playerRepository, playerStatusRepository,
                juniorStatusRepository, PlayerEntityMapper.INSTANCE, db.teamRepository());
        CountryRepository countryRepository = db.countryRepository();
        countryRepository.save(mapJsonFileToClass("countryEntities.json",
                new TypeReference<List<CountryEntity>>() {
                }));
    }

    @After
    public void closeDb() {
        db.close();
    }

    @Test
    public void given_players_when_save_then_allPlayersAreSaved() throws IOException {
        List<Player> players =
                mapJsonFileToClass("players.json", new TypeReference<List<Player>>() {});

        playerStorageService.save(players);

        List<PlayerWithStatuses> playersComplete = playerRepository.findAllComplete();
        checkPlayers(players, playersComplete);
        List<PlayerWithStatuses> seniorPlayers = playerRepository.findAllSeniorCompleteActive();
        List<PlayerWithStatuses> juniorPlayers = playerRepository.findAllJuniorCompleteActive();
        assertEquals(players.stream().flatMap(p -> {
                    if (p.getPlayerStatuses() == null) {
                        return Stream.empty();
                    }
                    return p.getPlayerStatuses().stream();
                }).count(),
                seniorPlayers.size());
        assertEquals(players.stream().flatMap(p -> {
                    if (p.getJuniorStatuses() == null) {
                        return Stream.empty();
                    }
                    return p.getJuniorStatuses().stream();
                }).count(),
                juniorPlayers.size());
    }

    @Test
    public void given_players_when_saveAddingNewStatus_then_allStatusesSaved() {
        List<Player> players1 = createPlayers(1L, 1);
        List<Player> players2 = createPlayers(2L, 2);

        playerStorageService.save(players1);
        playerStorageService.save(players2);

        players1.get(0).setPlayerStatuses(
                List.of(players1.get(0).getPlayerStatuses().get(0),
                        players2.get(0).getPlayerStatuses().get(0)));
        players1.get(0).setJuniorStatuses(
                List.of(players1.get(0).getJuniorStatuses().get(0),
                        players2.get(0).getJuniorStatuses().get(0)));

        List<PlayerWithStatuses> playersComplete = playerRepository.findAllComplete();
        checkPlayers(players1, playersComplete);
    }

    @Test
    public void given_junior_when_updateWithSeniorData_then_playerBecomesSenior(){
        playerStorageService.save(createJunior(1, 1));

        playerStorageService.save(createSenior(2, 2));

        assertEquals(1, playerStorageService.findSeniorActivePlayers().size());
        assertEquals(0, playerStorageService.findJuniorActivePlayers().size());
    }

    @Test
    public void given_player_when_updateWithoutPlayer_then_playerBecomesInactive(){
        playerStorageService.save(createSenior(2, 2));

        playerStorageService.save(Collections.emptyList());

        assertEquals(0, playerStorageService.findSeniorActivePlayers().size());
    }

    private static List<Player> createPlayers(long week, int skill) {
        Player player = Player.builder()
                .id(1L)
                .playerStatuses(List.of(PlayerStatus.builder()
                        .week(week)
                        .skillKeeper(skill)
                        .build()))
                .juniorStatuses(List.of(JuniorStatus.builder()
                        .week(week)
                        .skill(skill)
                        .build()))
                .build();
        return List.of(player);
    }

    private static List<Player> createJunior(long week, int skill) {
        Player player = Player.builder()
                .id(1L)
                .juniorStatuses(List.of(JuniorStatus.builder()
                        .week(week)
                        .skill(skill)
                        .build()))
                .build();
        return List.of(player);
    }

    private static List<Player> createSenior(long week, int skill) {
        Player player = Player.builder()
                .id(1L)
                .playerStatuses(List.of(PlayerStatus.builder()
                        .week(week)
                        .skillKeeper(skill)
                        .build()))
                .build();
        return List.of(player);
    }

    private void checkPlayers(List<Player> players, List<PlayerWithStatuses> playersComplete) {
        assertEquals(players.size(), playersComplete.size());
        players.forEach(player -> {
            Optional<PlayerWithStatuses> optPlayerComplete = playersComplete.stream()
                    .filter(playerComplete -> player.getId().equals(playerComplete.getPlayer().getId()))
                    .findFirst();
            Assert.assertTrue(optPlayerComplete.isPresent());
            checkPlayer(player, optPlayerComplete.get());
        });
    }

    private void checkPlayer(Player player, PlayerWithStatuses playerWithStatuses) {
        assertEquals(player.getAge(), playerWithStatuses.getPlayer().getAge());
        assertEquals(player.getBmi(), playerWithStatuses.getPlayer().getBmi());
        assertEquals(player.getAssists(), playerWithStatuses.getPlayer().getAssists());
        assertEquals(player.getCards(), playerWithStatuses.getPlayer().getCards());
        assertEquals(player.getGoals(), playerWithStatuses.getPlayer().getGoals());
        assertEquals(player.getHeight(), playerWithStatuses.getPlayer().getHeight());
        assertEquals(player.getInjuryDays(), playerWithStatuses.getPlayer().getInjuryDays());
        assertEquals(player.getMatches(), playerWithStatuses.getPlayer().getMatches());
        assertEquals(player.getName(), playerWithStatuses.getPlayer().getName());
        assertEquals(player.getNational(), playerWithStatuses.getPlayer().getNational());
        assertEquals(player.getNtAssists(), playerWithStatuses.getPlayer().getNtAssists());
        assertEquals(player.getNtCards(), playerWithStatuses.getPlayer().getNtCards());
        assertEquals(player.getNtGoals(), playerWithStatuses.getPlayer().getNtGoals());
        assertEquals(player.getNtMatches(), playerWithStatuses.getPlayer().getNtMatches());
        assertEquals(player.getSurname(), playerWithStatuses.getPlayer().getSurname());
        assertEquals(player.getTeamId(), playerWithStatuses.getPlayer().getTeamId());
        assertEquals(player.getValue(), playerWithStatuses.getPlayer().getValue());
        assertEquals(player.getWage(), playerWithStatuses.getPlayer().getWage());
        assertEquals(player.getYouthTeamId(), playerWithStatuses.getPlayer().getYouthTeamId());
        assertEquals(Optional.of(player).map(Player::getCountry)
                        .map(Country::getCountryId).orElse(null),
                Optional.of(playerWithStatuses).map(PlayerWithStatuses::getCountry)
                        .map(CountryEntity::getCountryId).orElse(null));
        assertEquals(size(player.getPlayerStatuses()), size(playerWithStatuses.getPlayerStatuses()));
        if (size(player.getPlayerStatuses()) > 0) {
            checkPlayerStatuses(player.getPlayerStatuses(), playerWithStatuses.getPlayerStatuses());
        }
        assertEquals(size(player.getJuniorStatuses()), size(playerWithStatuses.getJuniorStatuses()));
        if (size(player.getJuniorStatuses()) > 0) {
            checkJuniorStatuses(player.getJuniorStatuses(), playerWithStatuses.getJuniorStatuses());
        }
    }

    private void checkPlayerStatuses(List<PlayerStatus> playerStatuses,
                                     List<PlayerStatusEntity> playerStatusEntities) {
        playerStatuses.forEach(playerStatus -> {
            Optional<PlayerStatusEntity> optPlayerStatusEntity = playerStatusEntities.stream()
                    .filter(playerStatusEntity ->
                            playerStatus.getWeek().equals(playerStatusEntity.getWeek()))
                    .findFirst();
            assertTrue(optPlayerStatusEntity.isPresent());
            checkPlayerStatus(playerStatus, optPlayerStatusEntity.get());
        });
    }

    private void checkPlayerStatus(PlayerStatus playerStatus, PlayerStatusEntity playerStatusEntity) {
        assertEquals(playerStatus.getOfficialMinutes(), playerStatusEntity.getOfficialMinutes());
        assertEquals(playerStatus.getSkillDiscipline(), playerStatusEntity.getSkillDiscipline());
        assertEquals(playerStatus.getSkillDefending(), playerStatusEntity.getSkillDefending());
        assertEquals(playerStatus.getSkillKeeper(), playerStatusEntity.getSkillKeeper());
        assertEquals(playerStatus.getSkillForm(), playerStatusEntity.getSkillForm());
        assertEquals(playerStatus.getSkillExperience(), playerStatusEntity.getSkillExperience());
        assertEquals(playerStatus.getSkillPace(), playerStatusEntity.getSkillPace());
        assertEquals(playerStatus.getSkillPassing(), playerStatusEntity.getSkillPassing());
        assertEquals(playerStatus.getSkillDefending(), playerStatusEntity.getSkillDefending());
        assertEquals(playerStatus.getSkillPlaymaking(), playerStatusEntity.getSkillPlaymaking());
        assertEquals(playerStatus.getSkillScoring(), playerStatusEntity.getSkillScoring());
        assertEquals(playerStatus.getSkillStamina(), playerStatusEntity.getSkillStamina());
        assertEquals(playerStatus.getSkillTeamwork(), playerStatusEntity.getSkillTeamwork());
        assertEquals(playerStatus.getSkillTechnique(), playerStatusEntity.getSkillTechnique());
        assertEquals(playerStatus.getTrainerSkill(), playerStatusEntity.getTrainerSkill());
        assertEquals(playerStatus.getTrainingType(), playerStatusEntity.getTrainingType());
        assertEquals(playerStatus.getTransferList(), playerStatusEntity.getTransferList());
        assertEquals(playerStatus.getUnofficialMinutes(), playerStatusEntity.getUnofficialMinutes());
    }

    private void checkJuniorStatuses(List<JuniorStatus> juniorStatuses,
                                     List<JuniorStatusEntity> juniorStatusEntities) {
        juniorStatuses.forEach(juniorStatus -> {
            Optional<JuniorStatusEntity> optJuniorStatusEntity = juniorStatusEntities.stream()
                    .filter(juniorStatusEntity ->
                            juniorStatus.getWeek().equals(juniorStatusEntity.getWeek()))
                    .findFirst();
            assertTrue(optJuniorStatusEntity.isPresent());
            checkJuniorStatus(juniorStatus, optJuniorStatusEntity.get());
        });
    }

    private void checkJuniorStatus(JuniorStatus juniorStatus, JuniorStatusEntity juniorStatusEntity) {
        assertEquals(juniorStatus.getFormation(), juniorStatusEntity.getFormation());
        assertEquals(juniorStatus.getSkill(), juniorStatusEntity.getSkill());
        assertEquals(juniorStatus.getRemainingWeeks(), juniorStatusEntity.getRemainingWeeks());
    }

    private <T> int size(List<T> list) {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

}
