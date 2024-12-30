package com.estivy.sokkerarchitect.storage.service;

import com.estivy.sokkerarchitect.core.domain.Team;
import com.estivy.sokkerarchitect.storage.mapper.TeamEntityMapper;
import com.estivy.sokkerarchitect.storage.repositories.TeamRepository;

import javax.inject.Inject;

public class TeamStorageService {

    private final TeamRepository teamRepository;

    private final TeamEntityMapper teamEntityMapper;

    @Inject
    public TeamStorageService(TeamRepository teamRepository, TeamEntityMapper teamEntityMapper) {
        this.teamRepository = teamRepository;
        this.teamEntityMapper = teamEntityMapper;
    }

    public void save(Team team) {
        teamRepository.save(teamEntityMapper.mapToEntity(team));
    }

    public Team findTeam(){
        return teamEntityMapper.mapToDomain(teamRepository.findTeam());
    }

}
