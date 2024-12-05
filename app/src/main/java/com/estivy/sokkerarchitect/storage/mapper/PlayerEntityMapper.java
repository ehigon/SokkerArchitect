package com.estivy.sokkerarchitect.storage.mapper;

import com.estivy.sokkerarchitect.core.domain.JuniorStatus;
import com.estivy.sokkerarchitect.core.domain.Player;
import com.estivy.sokkerarchitect.core.domain.PlayerStatus;
import com.estivy.sokkerarchitect.storage.entities.JuniorStatusEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerEntity;
import com.estivy.sokkerarchitect.storage.entities.PlayerStatusEntity;
import com.estivy.sokkerarchitect.storage.relations.PlayerWithStatuses;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
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

    List<Player> mapToDomain(List<PlayerWithStatuses> playerWithStatuses);

    @Mapping(target = "id", source = "player.id")
    @Mapping(target = "name", source = "player.name")
    @Mapping(target = "surname", source = "player.surname")
    //@Mapping(target = "country", source = "player.country")
    @Mapping(target = "age", source = "player.age")
    @Mapping(target = "height", source = "player.height")
    @Mapping(target = "weight", source = "player.weight")
    @Mapping(target = "bmi", source = "player.bmi")
    @Mapping(target = "teamId", source = "player.teamId")
    @Mapping(target = "youthTeamId", source = "player.youthTeamId")
    @Mapping(target = "value", source = "player.value")
    @Mapping(target = "wage", source = "player.wage")
    @Mapping(target = "cards", source = "player.cards")
    @Mapping(target = "goals", source = "player.goals")
    @Mapping(target = "assists", source = "player.assists")
    @Mapping(target = "matches", source = "player.matches")
    @Mapping(target = "ntCards", source = "player.ntCards")
    @Mapping(target = "ntGoals", source = "player.ntGoals")
    @Mapping(target = "ntAssists", source = "player.ntAssists")
    @Mapping(target = "ntMatches", source = "player.ntMatches")
    @Mapping(target = "injuryDays", source = "player.injuryDays")
    @Mapping(target = "national", source = "player.national")
    Player mapToDomain(PlayerWithStatuses playerWithStatuses);
}
