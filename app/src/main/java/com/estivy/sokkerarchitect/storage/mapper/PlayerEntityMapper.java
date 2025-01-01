package com.estivy.sokkerarchitect.storage.mapper;

import com.estivy.sokkerarchitect.core.domain.JuniorStatus;
import com.estivy.sokkerarchitect.core.domain.Player;
import com.estivy.sokkerarchitect.core.domain.PlayerStatus;
import com.estivy.sokkerarchitect.storage.entities.CountryEntity;
import com.estivy.sokkerarchitect.storage.entities.JuniorStatusEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerStatusEntity;
import com.estivy.sokkerarchitect.storage.relations.PlayerWithStatuses;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper
public interface PlayerEntityMapper {

    PlayerEntityMapper INSTANCE = Mappers.getMapper(PlayerEntityMapper.class);

    List<PlayerEntity> mapToEntity(List<Player> player);

    @Mapping(target = "countryId", source = "player.country.countryId")
    @Mapping(target = "active", constant = "true")
    PlayerEntity mapToEntity(Player player);

    default List<PlayerStatusEntity> mapStatusToEntity(List<PlayerStatus> playerStatuses,
                   Long playerId){
        return playerStatuses.stream().map(p -> mapToEntity(p, playerId))
                .collect(Collectors.toList());
    }

    @Mapping(target = "id", ignore = true)
    PlayerStatusEntity mapToEntity(PlayerStatus playerStatus, Long playerId);

    default List<JuniorStatusEntity> mapJuniorStatusToEntity(List<JuniorStatus> juniorStatuses,
                   Long playerId){
        return juniorStatuses.stream().map(j -> mapToEntity(j, playerId))
                .collect(Collectors.toList());
    }

    @Mapping(target = "id", ignore = true)
    JuniorStatusEntity mapToEntity(JuniorStatus juniorStatus, Long playerId);

    default List<Player> mapToDomain(List<PlayerWithStatuses> playerWithStatuses, CountryEntity country){
        return playerWithStatuses.stream().map(p -> mapToDomain(p, country))
                .collect(Collectors.toList());
    }

    @Mapping(target = "id", source = "player.player.id")
    @Mapping(target = "name", source = "player.player.name")
    @Mapping(target = "surname", source = "player.player.surname")
    //@Mapping(target = "country", source = "player.country")
    @Mapping(target = "age", source = "player.player.age")
    @Mapping(target = "height", source = "player.player.height")
    @Mapping(target = "weight", source = "player.player.weight")
    @Mapping(target = "bmi", source = "player.player.bmi")
    @Mapping(target = "teamId", source = "player.player.teamId")
    @Mapping(target = "youthTeamId", source = "player.player.youthTeamId")
    @Mapping(target = "value", source = "player.player.value")
    @Mapping(target = "wage", source = "player.player.wage")
    @Mapping(target = "cards", source = "player.player.cards")
    @Mapping(target = "goals", source = "player.player.goals")
    @Mapping(target = "assists", source = "player.player.assists")
    @Mapping(target = "matches", source = "player.player.matches")
    @Mapping(target = "ntCards", source = "player.player.ntCards")
    @Mapping(target = "ntGoals", source = "player.player.ntGoals")
    @Mapping(target = "ntAssists", source = "player.player.ntAssists")
    @Mapping(target = "ntMatches", source = "player.player.ntMatches")
    @Mapping(target = "injuryDays", source = "player.player.injuryDays")
    @Mapping(target = "national", source = "player.player.national")
    @Mapping(target = "valueInCurrency", expression = "java(getValueInCurrency(player, country))")
    @Mapping(target = "currency", source = "country.currencyName")
    Player mapToDomain(PlayerWithStatuses player, CountryEntity country);

    default Double getValueInCurrency(PlayerWithStatuses player, CountryEntity country){
        return Optional.ofNullable(player.getPlayer().getValue())
                .map(v -> v / country.getCurrencyRate())
                .orElse(null);
    }
}
