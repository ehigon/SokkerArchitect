package com.estivy.sokkerarchitect.external.api.client;

import com.estivy.sokkerarchitect.external.api.client.dto.CountriesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.JuniorsDto;
import com.estivy.sokkerarchitect.external.api.client.dto.LoginResultDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchDetailDto;
import com.estivy.sokkerarchitect.external.api.client.dto.MatchesDto;
import com.estivy.sokkerarchitect.external.api.client.dto.PlayersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TeamDataDto;
import com.estivy.sokkerarchitect.external.api.client.dto.TrainersDto;
import com.estivy.sokkerarchitect.external.api.client.dto.VarsDto;
import com.estivy.sokkerarchitect.core.domain.exception.LoginException;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;

public class SokkerClient {

    public static final String ILOGIN = "ilogin";
    public static final String IPASSWORD = "ipassword";
    public static final String SET_COOKIE = "set-cookie";
    public static final String XMLSESSID = "XMLSESSID";

    private final SokkerAPI sokkerAPI;

    @Inject
    public SokkerClient(SokkerAPI sokkerAPI)  {
        this.sokkerAPI = sokkerAPI;
    }


    public LoginResultDto login(String user, String password){
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(ILOGIN, user)
                .addFormDataPart(IPASSWORD, password)
                .build();
        try {
            Response<String> responseString = sokkerAPI.login(requestBody).execute();
            if(responseString.body() == null || !responseString.body().startsWith("OK")){
                throw new LoginException(getErrorMessage(responseString.body()));
            }

            return LoginResultDto.builder()
                    .teamId(getTeamId(responseString.body()))
                    .xmlSession(getXmlsessId(responseString))
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public JuniorsDto getJuniors(String xmlSessionId){
        try{
            return sokkerAPI.getJuniors(xmlSessionId).execute().body();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public PlayersDto getPayers(String xmlSessionId, String teamId) {
        try{
            return sokkerAPI.getPlayers(xmlSessionId, teamId).execute().body();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public TeamDataDto getTeamData(String xmlSessionId, String teamId) {
        try{
            return sokkerAPI.getTeamData(xmlSessionId, teamId).execute().body();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public TrainersDto getTrainers(String xmlSessionId){
        try{
            return sokkerAPI.getTrainers(xmlSessionId).execute().body();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public VarsDto getVars(String xmlSessionId){
        try{
            return sokkerAPI.getVars(xmlSessionId).execute().body();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public CountriesDto getCountries(String xmlSessionId){
        try{
            return sokkerAPI.getCountries(xmlSessionId).execute().body();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public MatchesDto getMatches(String xmlSessionId, String teamId){
        try{
            return sokkerAPI.getMatches(xmlSessionId, teamId).execute().body();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public MatchDetailDto getMatchDetail(String xmlSessionId, Long matchId){
        try{
            return sokkerAPI.getMatchDetail(xmlSessionId, matchId).execute().body();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private String getTeamId(String body) {
        return getRightPart(body)
                .orElseThrow(() -> new LoginException("Team id not found in sokker response"));
    }

    private Optional<String> getRightPart(String string){
        int rightPartPos = string.indexOf('=')+1;
        if(rightPartPos<=0){
            return Optional.empty();
        }
        return Optional.of(string.substring(rightPartPos));
    }

    private String getXmlsessId(Response<String> responseString) {
        List<String> cookies = responseString.headers().toMultimap().get(SET_COOKIE);
        if(cookies == null){
            throw new LoginException("No cookies found in sokker response");
        }
        return cookies.stream()
                .filter(s -> s.startsWith(XMLSESSID))
                .findAny()
                .orElseThrow(() -> new LoginException("XMLSESSID not found in sokker response"));
    }

    private String getErrorMessage(String errorMessage) {
        if(errorMessage==null){
            return "Unknown error";
        }
        else{
            return errorMessage
                    .replace("1", "bad password")
                    .replace("3", "user has no team")
                    .replace("4", "user is banned")
                    .replace("5", "user is a bakrupt")
                    .replace("6", "user IP is blacklisted");
        }
    }

}
