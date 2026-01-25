package com.estivy.sokkerarchitect.external.api.util;

import com.estivy.sokkerarchitect.external.api.client.dto.CountriesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.JuniorsDto;
import com.estivy.sokkerarchitect.external.api.client.dto.LeagueDetailDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchDetailDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.PlayersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TeamDataDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TrainersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.VarsDto;


public class TestingDtos {
    private JuniorsDto juniorsDto;
    private PlayersDto playersDto;
    private TeamDataDto teamDataDto;
    private TrainersDto trainersDto;
    private VarsDto varsDto;
    private MatchesDto matchesDto;
    private MatchDetailDto match41753112DetailDto;
    private MatchDetailDto match41753124DetailDto;
    private MatchDetailDto match41979864DetailDto;
    private CountriesDto countriesDto;
    private LeagueDetailDto leagueDetailDto3;
    private LeagueDetailDto leagueDetailDto1254;

    public TestingDtos() {
    }

    public TestingDtos(JuniorsDto juniorsDto, PlayersDto playersDto, TeamDataDto teamDataDto,
                       TrainersDto trainersDto, VarsDto varsDto, MatchesDto matchesDto,
                       MatchDetailDto match41753112DetailDto, MatchDetailDto match41753124DetailDto,
                       MatchDetailDto match41979864DetailDto, CountriesDto countriesDto,
                       LeagueDetailDto leagueDetailDto3, LeagueDetailDto leagueDetailDto1254) {
        this.juniorsDto = juniorsDto;
        this.playersDto = playersDto;
        this.teamDataDto = teamDataDto;
        this.trainersDto = trainersDto;
        this.varsDto = varsDto;
        this.matchesDto = matchesDto;
        this.match41753112DetailDto = match41753112DetailDto;
        this.match41753124DetailDto = match41753124DetailDto;
        this.match41979864DetailDto = match41979864DetailDto;
        this.countriesDto = countriesDto;
        this.leagueDetailDto3 = leagueDetailDto3;
        this.leagueDetailDto1254 = leagueDetailDto1254;
    }

    public JuniorsDto getJuniorsDto() { return juniorsDto; }
    public void setJuniorsDto(JuniorsDto juniorsDto) { this.juniorsDto = juniorsDto; }

    public PlayersDto getPlayersDto() { return playersDto; }
    public void setPlayersDto(PlayersDto playersDto) { this.playersDto = playersDto; }

    public TeamDataDto getTeamDataDto() { return teamDataDto; }
    public void setTeamDataDto(TeamDataDto teamDataDto) { this.teamDataDto = teamDataDto; }

    public TrainersDto getTrainersDto() { return trainersDto; }
    public void setTrainersDto(TrainersDto trainersDto) { this.trainersDto = trainersDto; }

    public VarsDto getVarsDto() { return varsDto; }
    public void setVarsDto(VarsDto varsDto) { this.varsDto = varsDto; }

    public MatchesDto getMatchesDto() { return matchesDto; }
    public void setMatchesDto(MatchesDto matchesDto) { this.matchesDto = matchesDto; }

    public MatchDetailDto getMatch41753112DetailDto() { return match41753112DetailDto; }
    public void setMatch41753112DetailDto(MatchDetailDto match41753112DetailDto) { this.match41753112DetailDto = match41753112DetailDto; }

    public MatchDetailDto getMatch41753124DetailDto() { return match41753124DetailDto; }
    public void setMatch41753124DetailDto(MatchDetailDto match41753124DetailDto) { this.match41753124DetailDto = match41753124DetailDto; }

    public MatchDetailDto getMatch41979864DetailDto() { return match41979864DetailDto; }
    public void setMatch41979864DetailDto(MatchDetailDto match41979864DetailDto) { this.match41979864DetailDto = match41979864DetailDto; }

    public CountriesDto getCountriesDto() { return countriesDto; }
    public void setCountriesDto(CountriesDto countriesDto) { this.countriesDto = countriesDto; }

    public LeagueDetailDto getLeagueDetailDto3() {
        return leagueDetailDto3;
    }

    public void setLeagueDetailDto3(LeagueDetailDto leagueDetailDto3) {
        this.leagueDetailDto3 = leagueDetailDto3;
    }

    public LeagueDetailDto getLeagueDetailDto1254() {
        return leagueDetailDto1254;
    }

    public void setLeagueDetailDto1254(LeagueDetailDto leagueDetailDto1254) {
        this.leagueDetailDto1254 = leagueDetailDto1254;
    }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private JuniorsDto juniorsDto;
        private PlayersDto playersDto;
        private TeamDataDto teamDataDto;
        private TrainersDto trainersDto;
        private VarsDto varsDto;
        private MatchesDto matchesDto;
        private MatchDetailDto match41753112DetailDto;
        private MatchDetailDto match41753124DetailDto;
        private MatchDetailDto match41979864DetailDto;
        private CountriesDto countriesDto;
        private LeagueDetailDto leagueDetailDto3;
        private LeagueDetailDto leagueDetailDto1254;

        public Builder juniorsDto(JuniorsDto juniorsDto) { this.juniorsDto = juniorsDto; return this; }
        public Builder playersDto(PlayersDto playersDto) { this.playersDto = playersDto; return this; }
        public Builder teamDataDto(TeamDataDto teamDataDto) { this.teamDataDto = teamDataDto; return this; }
        public Builder trainersDto(TrainersDto trainersDto) { this.trainersDto = trainersDto; return this; }
        public Builder varsDto(VarsDto varsDto) { this.varsDto = varsDto; return this; }
        public Builder matchesDto(MatchesDto matchesDto) { this.matchesDto = matchesDto; return this; }
        public Builder match41753112DetailDto(MatchDetailDto match41753112DetailDto) { this.match41753112DetailDto = match41753112DetailDto; return this; }
        public Builder match41753124DetailDto(MatchDetailDto match41753124DetailDto) { this.match41753124DetailDto = match41753124DetailDto; return this; }
        public Builder match41979864DetailDto(MatchDetailDto match41979864DetailDto) { this.match41979864DetailDto = match41979864DetailDto; return this; }
        public Builder countriesDto(CountriesDto countriesDto) { this.countriesDto = countriesDto; return this; }
        public Builder leagueDetailDto3(LeagueDetailDto leagueDetailDto3) { this.leagueDetailDto3 = leagueDetailDto3; return this; }
        public Builder leagueDetailDto1254(LeagueDetailDto leagueDetailDto1254) { this.leagueDetailDto1254 = leagueDetailDto1254; return this; }

        public TestingDtos build() {
            return new TestingDtos(juniorsDto, playersDto, teamDataDto, trainersDto, varsDto, matchesDto,
                    match41753112DetailDto, match41753124DetailDto, match41979864DetailDto, countriesDto,
                    leagueDetailDto3, leagueDetailDto1254);
        }
    }
}
