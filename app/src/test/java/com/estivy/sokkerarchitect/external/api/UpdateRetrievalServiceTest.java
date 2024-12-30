package com.estivy.sokkerarchitect.external.api;

import static com.estivy.sokkerarchitect.external.api.util.FileMapperUtil.mapJsonFileToClass;
import static com.estivy.sokkerarchitect.external.api.util.FileMapperUtil.mapXmlFileToClass;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.estivy.sokkerarchitect.core.domain.JuniorStatus;
import com.estivy.sokkerarchitect.core.domain.Player;
import com.estivy.sokkerarchitect.core.domain.PlayerStatus;
import com.estivy.sokkerarchitect.core.domain.Status;
import com.estivy.sokkerarchitect.external.api.client.SokkerClient;
import com.estivy.sokkerarchitect.external.api.client.dto.CountriesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.JuniorDto;
import com.estivy.sokkerarchitect.external.api.client.dto.JuniorsDto;
import com.estivy.sokkerarchitect.external.api.client.dto.LoginResultDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchDetailDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.PlayerDto;
import com.estivy.sokkerarchitect.external.api.client.dto.PlayersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TeamDataDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TrainersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.VarsDto;
import com.estivy.sokkerarchitect.external.api.client.mapper.PlayerMapper;
import com.estivy.sokkerarchitect.external.api.client.mapper.TeamMapper;
import com.estivy.sokkerarchitect.external.api.service.UpdateRetrievalService;
import com.estivy.sokkerarchitect.external.api.util.TestingDtos;
import com.estivy.sokkerarchitect.external.api.util.TrainingResult;
import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UpdateRetrievalServiceTest {

    public static final String XML_SESSION_ID = "LGHROFG2343OF40F";
    @Mock
    SokkerClient sokkerClient;

    UpdateRetrievalService updateRetrievalService;

    @Before
    public void setUp() {
        updateRetrievalService = new UpdateRetrievalService(
                sokkerClient, PlayerMapper.INSTANCE, TeamMapper.INSTANCE);
    }

    @Test
    public void given_sokkerClient_when_getUpdate_updateIsReceived() throws IOException {
        TestingDtos dtos = loadDtos();
        mockSokkerClient(dtos);

        Status status = updateRetrievalService.getUpdate("login", "password");

        checkResults(dtos, status);
    }

    private void checkResults(TestingDtos dtos, Status status) throws IOException {
        List<TrainingResult> trainingResults = mapJsonFileToClass(
                "trainingResults.json", new TypeReference<List<TrainingResult>>() {
                });
        dtos.getJuniorsDto().getJuniors().forEach(j -> checkJunior(j, dtos, status));
        dtos.getPlayersDto().getPlayers().forEach(
                p -> checkPlayer(p, dtos, status, findTrainingResult(p.getId(), trainingResults)));
        checkCountry(dtos.getTeamDataDto(), status);
    }

    private void checkCountry(TeamDataDto teamDataDto, Status status) {
        Assert.assertEquals("Team country should match",
                teamDataDto.getTeam().getCountryId(), status.getTeam().getCountryId());
    }

    private TrainingResult findTrainingResult(Long id, List<TrainingResult> trainingResults) {
        Optional<TrainingResult> optionalTrainingResult = trainingResults.stream()
                .filter(tr -> tr.getId().equals(id))
                .findFirst();
        Assert.assertTrue(optionalTrainingResult.isPresent());
        return optionalTrainingResult.get();
    }

    private void checkJunior(JuniorDto juniorDto, TestingDtos dtos, Status status) {
        Optional<Player> opPlayer = status.getPlayers().stream()
                .filter(p -> p.getId().equals(juniorDto.getId())).findFirst();
        Assert.assertTrue(opPlayer.isPresent());
        Player player = opPlayer.get();
        Assert.assertEquals("Not matching age for junior " + player.getId(),
                juniorDto.getAge(), player.getAge());
        Assert.assertEquals("Not matching bmi for junior " + player.getId(),
                juniorDto.getBmi(), player.getBmi());
        Assert.assertEquals("Not matching age for junior " + player.getId(),
                juniorDto.getAge(), player.getAge());
        Assert.assertEquals("Not matching name for junior " + player.getId(),
                juniorDto.getName(), player.getName());
        Assert.assertEquals("Not matching surname for junior " + player.getId(),
                juniorDto.getSurname(), player.getSurname());
        Assert.assertEquals("Not matching height for junior " + player.getId(),
                juniorDto.getHeight(), player.getHeight());
        Assert.assertEquals("Not matching weight for junior " + player.getId(),
                juniorDto.getWeight(), player.getWeight());
        Assert.assertNotNull("Junior should have junior status " + player.getId(),
                player.getJuniorStatuses());
        Assert.assertEquals("Junior should have one junior status " + player.getId(),
                1, player.getJuniorStatuses().size());
        JuniorStatus juniorStatus = player.getJuniorStatuses().get(0);
        Assert.assertEquals("Not matching formation for junior " + player.getId(),
                juniorDto.getFormation().intValue(), juniorStatus.getFormation().getValue());
        Assert.assertEquals("Not matching week for junior " + player.getId(),
                dtos.getVarsDto().getWeek(), juniorStatus.getWeek());
        Assert.assertEquals("Not matching skill for junior " + player.getId(),
                juniorDto.getSkill(), juniorStatus.getSkill());
        Assert.assertEquals("Not matching remaining weeks for junior " + player.getId(),
                juniorDto.getWeeks(), juniorStatus.getRemainingWeeks());

    }

    private void checkPlayer(PlayerDto playerDto, TestingDtos dtos, Status status,
                             TrainingResult trainingResult) {
        Optional<Player> opPlayer = status.getPlayers().stream()
                .filter(p -> p.getId().equals(playerDto.getId())).findFirst();
        Assert.assertTrue(opPlayer.isPresent());
        Player player = opPlayer.get();
        Assert.assertEquals("Not matching age for player " + player.getId(),
                playerDto.getAge(), player.getAge());
        Assert.assertEquals("Not matching value for player " + player.getId(),
                playerDto.getValue(), player.getValue());
        Assert.assertEquals("Not matching bmi for player " + player.getId(),
                playerDto.getBmi(), player.getBmi());
        Assert.assertEquals("Not matching age for player " + player.getId(),
                playerDto.getAge(), player.getAge());
        Assert.assertEquals("Not matching height for player " + player.getId(),
                playerDto.getHeight(), player.getHeight());
        Assert.assertEquals("Not matching name for player " + player.getId(),
                playerDto.getName(), player.getName());
        Assert.assertEquals("Not matching matches for player " + player.getId(),
                playerDto.getMatches(), player.getMatches());
        Assert.assertEquals("Not matching assists for player " + player.getId(),
                playerDto.getAssists(), player.getAssists());
        Assert.assertEquals("Not matching cards for player " + player.getId(),
                playerDto.getCards(), player.getCards());
        Assert.assertEquals("Not matching country for player " + player.getId(),
                playerDto.getCountryId(), player.getCountry().getCountryId());
        Assert.assertEquals("Not matching goals for player " + player.getId(),
                playerDto.getGoals(), player.getGoals());
        Assert.assertEquals("Not matching injury days for player " + player.getId(),
                playerDto.getInjuryDays(), player.getInjuryDays());
        Assert.assertEquals("Not matching national for player " + player.getId(),
                playerDto.getNational().intValue(), player.getNational().getValue());
        Assert.assertEquals("Not matching ntAssists for player " + player.getId(),
                playerDto.getNtAssists(), player.getNtAssists());
        Assert.assertEquals("Not matching ntCards for player " + player.getId(),
                playerDto.getNtCards(), player.getNtCards());
        Assert.assertEquals("Not matching ntGoals for player " + player.getId(),
                playerDto.getNtGoals(), player.getNtGoals());
        Assert.assertEquals("Not matching ntMatches for player " + player.getId(),
                playerDto.getNtMatches(), player.getNtMatches());
        Assert.assertEquals("Not matching surname for player " + player.getId(),
                playerDto.getSurname(), player.getSurname());
        Assert.assertEquals("Not matching teamId for player " + player.getId(),
                playerDto.getTeamId(), player.getTeamId());
        Assert.assertEquals("Not matching wage for player " + player.getId(),
                playerDto.getWage(), player.getWage());
        Assert.assertEquals("Player should have player status " + player.getId(),
                playerDto.getYouthTeamId(), player.getYouthTeamId());
        Assert.assertNotNull("Player should have player status " + player.getId(),
                player.getPlayerStatuses());
        Assert.assertEquals("Player should have one player status " + player.getId(),
                1, player.getPlayerStatuses().size());
        PlayerStatus playerStatus = player.getPlayerStatuses().get(0);
        Assert.assertEquals("Not matching defending for player " + player.getId(),
                playerDto.getSkillDefending(), playerStatus.getSkillDefending());
        Assert.assertEquals("Not matching keeper for player " + player.getId(),
                playerDto.getSkillKeeper(), playerStatus.getSkillKeeper());
        Assert.assertEquals("Not matching pace for player " + player.getId(),
                playerDto.getSkillPace(), playerStatus.getSkillPace());
        Assert.assertEquals("Not matching discipline for player " + player.getId(),
                playerDto.getSkillDiscipline(), playerStatus.getSkillDiscipline());
        Assert.assertEquals("Not matching experience for player " + player.getId(),
                playerDto.getSkillExperience(), playerStatus.getSkillExperience());
        Assert.assertEquals("Not matching form for player " + player.getId(),
                playerDto.getSkillForm(), playerStatus.getSkillForm());
        Assert.assertEquals("Not matching passing for player " + player.getId(),
                playerDto.getSkillPassing(), playerStatus.getSkillPassing());
        Assert.assertEquals("Not matching playmaking for player " + player.getId(),
                playerDto.getSkillPlaymaking(), playerStatus.getSkillPlaymaking());
        Assert.assertEquals("Not matching scoring for player " + player.getId(),
                playerDto.getSkillScoring(), playerStatus.getSkillScoring());
        Assert.assertEquals("Not matching stamina for player " + player.getId(),
                playerDto.getSkillStamina(), playerStatus.getSkillStamina());
        Assert.assertEquals("Not matching team work for player " + player.getId(),
                playerDto.getSkillTeamwork(), playerStatus.getSkillTeamwork());
        Assert.assertEquals("Not matching technique for player " + player.getId(),
                playerDto.getSkillTechnique(), playerStatus.getSkillTechnique());
        Assert.assertEquals("Not matching week for player " + player.getId(),
                dtos.getVarsDto().getWeek(), playerStatus.getWeek());
        Assert.assertEquals("Not matching trainer type for player " + player.getId(),
                trainingResult.getTrainingType(), playerStatus.getTrainingType());
        Assert.assertEquals("Not matching trainer skill for player " + player.getId(),
                trainingResult.getTrainerSkill(), playerStatus.getTrainerSkill());
        Assert.assertEquals("Not matching official minutes for player " + player.getId(),
                trainingResult.getOfficialMinutes(), playerStatus.getOfficialMinutes());
        Assert.assertEquals("Not matching unofficial minutes for player " + player.getId(),
                trainingResult.getUnofficialMinutes(), playerStatus.getUnofficialMinutes());
    }

    private TestingDtos loadDtos() throws IOException {
        return TestingDtos.builder()
                .juniorsDto(mapXmlFileToClass("juniors.xml", JuniorsDto.class))
                .playersDto(mapXmlFileToClass("players-20425.xml", PlayersDto.class))
                .teamDataDto(mapXmlFileToClass("team-20425.xml", TeamDataDto.class))
                .trainersDto(mapXmlFileToClass("trainers.xml", TrainersDto.class))
                .varsDto(mapXmlFileToClass("vars.xml", VarsDto.class))
                .matchesDto(mapXmlFileToClass("matches-team-20425.xml", MatchesDto.class))
                .match41753112DetailDto(mapXmlFileToClass(
                        "match-41753112.xml", MatchDetailDto.class))
                .match41753124DetailDto(mapXmlFileToClass(
                        "match-41753124.xml", MatchDetailDto.class))
                .match41979864DetailDto(mapXmlFileToClass(
                        "match-41979864.xml", MatchDetailDto.class))
                .countriesDto(mapXmlFileToClass("countries.xml", CountriesDto.class))
                .build();
    }

    private void mockSokkerClient(TestingDtos dtos) throws IOException {
        when(sokkerClient.login(anyString(), anyString()))
                .thenReturn(LoginResultDto.builder()
                        .teamId("20425")
                        .xmlSession(XML_SESSION_ID)
                        .build());
        when(sokkerClient.getJuniors(anyString())).thenReturn(dtos.getJuniorsDto());
        when(sokkerClient.getPayers(anyString(), anyString())).thenReturn(dtos.getPlayersDto());
        when(sokkerClient.getTeamData(anyString(), anyString())).thenReturn(dtos.getTeamDataDto());
        when(sokkerClient.getTrainers(anyString())).thenReturn(dtos.getTrainersDto());
        when(sokkerClient.getVars(anyString())).thenReturn(dtos.getVarsDto());
        when(sokkerClient.getMatches(anyString(), anyString())).thenReturn(dtos.getMatchesDto());
        when(sokkerClient.getMatchDetail(XML_SESSION_ID, 41973708L))
                .thenReturn(dtos.getMatch41753112DetailDto());
        when(sokkerClient.getMatchDetail(XML_SESSION_ID, 41753112L))
                .thenReturn(dtos.getMatch41753124DetailDto());
        when(sokkerClient.getMatchDetail(XML_SESSION_ID, 41753124L))
                .thenReturn(dtos.getMatch41979864DetailDto());
        when(sokkerClient.getCountries(anyString()))
                .thenReturn(dtos.getCountriesDto());
    }

}