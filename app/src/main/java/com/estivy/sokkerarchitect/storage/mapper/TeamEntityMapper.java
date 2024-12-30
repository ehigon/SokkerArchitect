package com.estivy.sokkerarchitect.storage.mapper;

import com.estivy.sokkerarchitect.core.domain.Team;
import com.estivy.sokkerarchitect.storage.entities.TeamEntity;
import com.estivy.sokkerarchitect.storage.relations.TeamWithCountry;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamEntityMapper {

    TeamEntityMapper INSTANCE = Mappers.getMapper(TeamEntityMapper.class);

    @Mapping(target = "id", expression = "java(TeamEntity.UNIQUE_ID)")
    TeamEntity mapToEntity(Team team);

    Team mapToDomain(TeamEntity teamEntity);

}
