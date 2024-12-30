package com.estivy.sokkerarchitect.external.api.client.mapper;

import static com.estivy.sokkerarchitect.core.domain.TrainingType.GENERAL;

import com.estivy.sokkerarchitect.core.domain.Country;
import com.estivy.sokkerarchitect.core.domain.JuniorStatus;
import com.estivy.sokkerarchitect.core.domain.Player;
import com.estivy.sokkerarchitect.core.domain.PlayerStatus;
import com.estivy.sokkerarchitect.core.domain.TrainingType;
import com.estivy.sokkerarchitect.external.api.client.dto.CountriesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.CountryDto;
import com.estivy.sokkerarchitect.external.api.client.dto.JuniorDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchDetailDto;
import com.estivy.sokkerarchitect.external.api.client.dto.PlayerDto;
import com.estivy.sokkerarchitect.external.api.client.dto.PlayerStatDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TeamDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TrainerDto;
import com.estivy.sokkerarchitect.external.api.client.dto.VarsDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);
    int GK_POSITION = 0;
    int DEFENSE_POSITION = 1;
    int MIDFIELDER_POSITION = 2;
    int ATTACKER_POSITION = 3;
    int TRAINING_UPDATE_DAY = 5;

    @Mapping(target = "national",
            expression = "java(com.estivy.sokkerarchitect.core.domain.National.fromValue(" +
                    "player.getNational()))")
    @Mapping(target = "playerStatuses",
            expression = "java(java.util.List.of(toDomainStatus(player, optPrincipalTrainer, team, " +
                    "lastWeekMatchDetails, vars)))")
    @Mapping(target = "name", source = "player.name")
    @Mapping(target = "country", expression = "java(findCountry(countries, player.getCountryId()))")
    @Mapping(target = "teamId", source = "player.teamId")
    @Mapping(target = "juniorStatuses", ignore = true)
    @Mapping(target = "valueInCurrency", ignore = true)
    @Mapping(target = "currency", ignore = true)
    Player toDomain(PlayerDto player, Optional<TrainerDto> optPrincipalTrainer, TeamDto team,
                    List<MatchDetailDto> lastWeekMatchDetails, VarsDto vars, CountriesDto countries);


    default PlayerStatus toDomainStatus(PlayerDto player, Optional<TrainerDto> optPrincipalTrainer,
                TeamDto team, List<MatchDetailDto> lastWeekMatchDetails, VarsDto vars){
        PlayerStatus playerStatus = toDomainStatusBase(player);
        playerStatus.setTrainingType(getTrainingType(player, team));
        optPrincipalTrainer.ifPresent(pTrainer ->playerStatus.setTrainerSkill(
                getTrainingSkill(playerStatus.getTrainingType(), pTrainer)));
        setMinutesPlayed(playerStatus, player, lastWeekMatchDetails, team.getTeamId());
        setWeek(playerStatus, getTrainingWeek(vars));
        setInjured(playerStatus, player, vars);
        return playerStatus;
    }

    default Integer getTrainingSkill(TrainingType trainingType, TrainerDto principalTrainer){
        switch (trainingType){
            case STAMINA:
                return principalTrainer.getSkillStamina();
            case KEEPER:
                return principalTrainer.getSkillKeeper();
            case PLAYMAKING:
                return principalTrainer.getSkillPlaymaking();
            case PASSING:
                return principalTrainer.getSkillPassing();
            case TECHNIQUE:
                return principalTrainer.getSkillTechnique();
            case DEFENDING:
                return principalTrainer.getSkillDefending();
            case SCORING:
                return principalTrainer.getSkillScoring();
            case PACE:
                return principalTrainer.getSkillPace();
            default:
                return principalTrainer.getSkillCoach();
        }
    }

    default TrainingType getTrainingType(PlayerDto player, TeamDto team){
        if(Boolean.FALSE.equals(player.getInTrainingSlot())){
            return GENERAL;
        }
        switch (player.getTrainingPosition()){
            case GK_POSITION:
                return TrainingType.fromValue(team.getTrainingTypeGk());
            case DEFENSE_POSITION:
                return TrainingType.fromValue(team.getTrainingTypeDef());
            case MIDFIELDER_POSITION:
                return TrainingType.fromValue(team.getTrainingTypeMid());
            case ATTACKER_POSITION:
                return TrainingType.fromValue(team.getTrainingTypeAtt());
            default:
                return GENERAL;
        }
    }

    default void setMinutesPlayed(PlayerStatus playerStatus, PlayerDto player,
                                  List<MatchDetailDto> lastWeekMatchDetails, Long teamId){
        addTrainedTime(playerStatus, player, lastWeekMatchDetails, teamId, true);
        addTrainedTime(playerStatus, player, lastWeekMatchDetails, teamId, false);
    }

    default void addTrainedTime(PlayerStatus playerStatus, PlayerDto player,
                                List<MatchDetailDto> lastWeekMatchDetails, Long teamId, boolean official){
        lastWeekMatchDetails.stream()
                .filter(m -> isOfficial(m) == official)
                .flatMap(m -> m.getPlayerStats().stream())
                .filter(ps -> ps.getTeamId().equals(teamId))
                .flatMap(ps -> ps.getPlayerStat().stream())
                .filter(p -> p.getPlayerId().equals(player.getId()))
                .filter(p -> p.getFormation().equals(player.getTrainingPosition()))
                .forEach(p -> addTrainedTime(playerStatus, p, official));
    }

    default boolean isOfficial(MatchDetailDto matchDetail){
        return matchDetail.getInfo().getSeason() != 0 || matchDetail.getInfo().getRound() != 0;
    }

    default void addTrainedTime(PlayerStatus playerStatus, PlayerStatDto playerStat, boolean official) {
        if(playerStat.getNumber()>11) {
            return;
        }
        int timeOut = playerStat.getTimeOut() == 0 ? 90 : playerStat.getTimeOut();
        int timePlayed = timeOut - playerStat.getTimeIn();
        if(official){
            playerStatus.setOfficialMinutes(playerStatus.getOfficialMinutes() + timePlayed);
        }else{
            playerStatus.setUnofficialMinutes(playerStatus.getUnofficialMinutes() + timePlayed);
        }
    }

    default long getTrainingWeek(VarsDto vars) {
        return vars.getWeek() + (vars.getDay() >= TRAINING_UPDATE_DAY ? 1 : 0);
    }

    default void setWeek(PlayerStatus playerStatus, Long week){
        playerStatus.setWeek(week);
    }

    default void setInjured(PlayerStatus playerStatus, PlayerDto player, VarsDto vars){
        playerStatus.setInjured(isInjuredInTrainingDay(player, vars));
    }

    default boolean isInjuredInTrainingDay(PlayerDto player, VarsDto vars) {
        if(player.getInjuryDays()==0){
            return false;
        }
        return player.getInjuryDays() + vars.getDay() - TRAINING_UPDATE_DAY
                + (vars.getDay() >= TRAINING_UPDATE_DAY ? 0 : 7) >= 6;
    }

    default Country findCountry(CountriesDto countriesDto, Integer countryId){
        return countriesDto.getCountries().stream()
                .filter(c -> c.getCountryId().equals(countryId))
                .findFirst()
                .map(this::mapToDomain)
                .orElse(null);
    }

    List<Country> mapCountriesToDomain(List<CountryDto> countries);

    Country mapToDomain(CountryDto countryDto);

    @Mapping(target = "officialMinutes", constant = "0")
    @Mapping(target = "unofficialMinutes", constant = "0")
    @Mapping(target = "trainingType", ignore = true)
    @Mapping(target = "trainerSkill", ignore = true)
    @Mapping(target = "week", ignore = true)
    @Mapping(target = "injured", ignore = true)
    PlayerStatus toDomainStatusBase(PlayerDto player);

    @Mapping(target = "juniorStatuses",
            expression = "java(java.util.List.of(toDomainStatus(junior, vars, optJuniorTrainer)))")
    @Mapping(target = "playerStatuses", ignore = true)
    @Mapping(target = "teamId", ignore = true)
    @Mapping(target = "youthTeamId", ignore = true)
    @Mapping(target = "value", ignore = true)
    @Mapping(target = "wage", ignore = true)
    @Mapping(target = "cards", ignore = true)
    @Mapping(target = "goals", ignore = true)
    @Mapping(target = "assists", ignore = true)
    @Mapping(target = "matches", ignore = true)
    @Mapping(target = "ntCards", ignore = true)
    @Mapping(target = "ntGoals", ignore = true)
    @Mapping(target = "ntAssists", ignore = true)
    @Mapping(target = "ntMatches", ignore = true)
    @Mapping(target = "injuryDays", ignore = true)
    @Mapping(target = "national", ignore = true)
    @Mapping(target = "name", source = "junior.name")
    @Mapping(target = "valueInCurrency", ignore = true)
    @Mapping(target = "currency", ignore = true)
    Player toDomain(JuniorDto junior, VarsDto vars, Country country, Optional<TrainerDto> optJuniorTrainer);

    @Mapping(target = "remainingWeeks", source="junior.weeks")
    @Mapping(target = "formation",
            expression = "java(com.estivy.sokkerarchitect.core.domain.JuniorFormation.fromValue(" +
                    "junior.getFormation()))")
    @Mapping(target = "week", expression = "java(getTrainingWeek(vars))")
    @Mapping(target = "trainerSkill", expression = "java(getTrainingSkill(optJuniorTrainer))")
    JuniorStatus toDomainStatus(JuniorDto junior, VarsDto vars, Optional<TrainerDto> optJuniorTrainer);

    default Integer getTrainingSkill(Optional<TrainerDto> optJuniorTrainer){
        return optJuniorTrainer.map(TrainerDto::getSkillCoach).orElse(null);
    }

}
