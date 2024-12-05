package com.estivy.sokkerarchitect.external.api.util;

import com.estivy.sokkerarchitect.external.api.client.dto.CountriesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.JuniorsDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchDetailDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.PlayersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TeamDataDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TrainersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.VarsDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
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
}
