package com.estivy.sokkerarchitect.external.api.client.mapper;

import com.estivy.sokkerarchitect.core.domain.Team;
import com.estivy.sokkerarchitect.external.api.client.dto.TeamDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamMapper {
    public static final TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    Team mapToDomain(TeamDto teamDto);
}
