package com.estivy.sokkerarchitect.external.api.service;

import static com.estivy.sokkerarchitect.external.api.client.mapper.PlayerMapper.TRAINING_UPDATE_DAY;

import androidx.annotation.NonNull;

import com.estivy.sokkerarchitect.core.domain.Country;
import com.estivy.sokkerarchitect.core.domain.Player;
import com.estivy.sokkerarchitect.core.domain.Status;
import com.estivy.sokkerarchitect.core.domain.TrainerJob;
import com.estivy.sokkerarchitect.external.api.client.SokkerClient;
import com.estivy.sokkerarchitect.external.api.client.dto.CountriesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.JuniorDto;
import com.estivy.sokkerarchitect.external.api.client.dto.JuniorsDto;
import com.estivy.sokkerarchitect.external.api.client.dto.LoginResultDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchDetailDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.PlayerDto;
import com.estivy.sokkerarchitect.external.api.client.dto.PlayersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TeamDataDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TeamDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TrainerDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TrainersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.VarsDto;
import com.estivy.sokkerarchitect.external.api.client.mapper.PlayerMapper;
import com.estivy.sokkerarchitect.external.api.client.mapper.TeamMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;

public class UpdateRetrievalService {

    private final SokkerClient sokkerClient;

    private final PlayerMapper playerMapper;

    private final TeamMapper teamMapper;

    @Inject
    public UpdateRetrievalService(SokkerClient sokkerClient, PlayerMapper playerMapper, TeamMapper teamMapper) {
        this.sokkerClient = sokkerClient;
        this.playerMapper = playerMapper;
        this.teamMapper = teamMapper;
    }

    public Status getUpdate(String login, String password) {
        LoginResultDto loginResult = sokkerClient.login(login, password);
        String teamId = loginResult.getTeamId();
        String xmlSession = loginResult.getXmlSession();
        JuniorsDto juniors = sokkerClient.getJuniors(xmlSession);
        PlayersDto players = sokkerClient.getPayers(xmlSession, teamId);
        TeamDataDto teamData = sokkerClient.getTeamData(xmlSession, teamId);
        TrainersDto trainers = sokkerClient.getTrainers(xmlSession);
        VarsDto vars = sokkerClient.getVars(xmlSession);
        CountriesDto countries = sokkerClient.getCountries(xmlSession);
        MatchesDto matchesDto = sokkerClient.getMatches(xmlSession, teamId);
        List<Long> lastWeekMatchesIds = getWeekMatchIds(matchesDto, getTrainingWeek(vars));
        List<MatchDetailDto> lastWeekMatchDetails = getMatchDetails(xmlSession, lastWeekMatchesIds);
        return generateStatus(juniors, players, trainers, vars, lastWeekMatchDetails,
                teamData.getTeam(), countries);
    }

    private Status generateStatus(JuniorsDto juniors, PlayersDto players, TrainersDto trainers,
                                  VarsDto vars, List<MatchDetailDto> lastWeekMatchDetails, TeamDto teamDto,
                                  CountriesDto countries) {
        Status status = new Status();
        status.setPlayers(getPlayerList(juniors, players, trainers, lastWeekMatchDetails, teamDto,
                vars, countries));
        status.setTeam(teamMapper.mapToDomain(teamDto));
        status.setCountries(playerMapper.mapCountriesToDomain(countries.getCountries()));
        return status;
    }

    private List<Player> getPlayerList(JuniorsDto juniors, PlayersDto players, TrainersDto trainers,
                                       List<MatchDetailDto> lastWeekMatchDetails, TeamDto teamDto, VarsDto vars,
                                       CountriesDto countries) {
        Country country = playerMapper.findCountry(countries, teamDto.getCountryId());
        Optional<TrainerDto> optPrincipalTrainer = getTrainer(trainers, TrainerJob.PRINCIPAL);
        Stream<Player> playerStream = getPlayersStream(players)
                .map(p -> playerMapper.toDomain(p, optPrincipalTrainer, teamDto,
                        lastWeekMatchDetails, vars, countries));
        Optional<TrainerDto> optJuniorTrainer = getTrainer(trainers, TrainerJob.JUNIOR);
        Stream<Player> juniorStream = getJuniorStream(juniors)
                .map(j -> playerMapper.toDomain(j, vars, country, optJuniorTrainer));

        return Stream.concat(playerStream, juniorStream).collect(Collectors.toList());
    }

    private static @NonNull Stream<PlayerDto> getPlayersStream(PlayersDto players) {
        if(players.getPlayers() == null){
            return Stream.empty();
        }
        return players.getPlayers().stream();
    }

    private static @NonNull Stream<JuniorDto> getJuniorStream(JuniorsDto juniors) {
        if(juniors.getJuniors() == null){
            return Stream.empty();
        }
        return juniors.getJuniors().stream();
    }


    private Optional<TrainerDto> getTrainer(TrainersDto trainers, TrainerJob trainerJob) {
        return trainers.getTrainers().stream()
                .filter(t -> t.getJob().equals(trainerJob.getValue()))
                .findFirst();
    }

    private Long getTrainingWeek(VarsDto vars) {
        return vars.getWeek() - (vars.getDay() < TRAINING_UPDATE_DAY ? 1 : 0);
    }

    private List<Long> getWeekMatchIds(MatchesDto matchesDto, Long week) {
        return matchesDto.getMatches().stream()
                .filter(m -> isInCurrentWeekTraining(m, week))
                .map(MatchDto::getMatchId)
                .collect(Collectors.toList());
    }

    private List<MatchDetailDto> getMatchDetails(String xmlSessionId, List<Long> matchesIds) {
        return matchesIds.stream()
                .map(matchId -> sokkerClient.getMatchDetail(xmlSessionId, matchId))
                .collect(Collectors.toList());
    }

    private boolean isInCurrentWeekTraining(MatchDto matchDto, Long week) {
        return (matchDto.getWeek().equals(week) && matchDto.getDay() < TRAINING_UPDATE_DAY)
                || (matchDto.getWeek().equals(week - 1) && matchDto.getDay() >= TRAINING_UPDATE_DAY);
    }

}
