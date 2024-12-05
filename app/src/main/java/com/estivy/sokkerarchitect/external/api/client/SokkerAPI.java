package com.estivy.sokkerarchitect.external.api.client;

import com.estivy.sokkerarchitect.external.api.client.dto.CountriesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.JuniorsDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchDetailDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.PlayersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TeamDataDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TrainersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.VarsDto;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SokkerAPI {

    @POST("/start.php?session=xml")
    Call<String> login(@Body RequestBody body);

    @GET("/xml/juniors.xml")
    Call<JuniorsDto> getJuniors(@Header("Cookie") String xmlSessionId);

    @GET("/xml/players-{teamId}.xml")
    Call<PlayersDto> getPlayers(@Header("Cookie") String xmlSessionId, @Path("teamId") String teamId);

    @GET("/xml/team-{teamId}.xml")
    Call<TeamDataDto> getTeamData(@Header("Cookie") String xmlSessionId, @Path("teamId") String teamId);

    @GET("/xml/trainers.xml")
    Call<TrainersDto> getTrainers(@Header("Cookie") String xmlSessionId);

    @GET("/xml/vars.xml")
    Call<VarsDto> getVars(@Header("Cookie") String xmlSessionId);

    @GET("/xml/countries.xml")
    Call<CountriesDto> getCountries(@Header("Cookie") String xmlSessionId);

    @GET("/xml/matches-team-{teamId}.xml")
    Call<MatchesDto> getMatches(@Header("Cookie") String xmlSessionId, @Path("teamId") String teamId);

    @GET("/xml/match-{matchId}.xml")
    Call<MatchDetailDto> getMatchDetail(@Header("Cookie") String xmlSessionId, @Path("matchId") Long matchId);
}
