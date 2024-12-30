package com.estivy.sokkerarchitect.core.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Player {

    private List<PlayerStatus> playerStatuses;

    private List<JuniorStatus> juniorStatuses;

    private Long id;
    private String name;
    private String surname;
    private Country country;
    private Integer age;
    private Integer height;
    private Double weight;
    private Double bmi;
    private Long teamId;
    private Long youthTeamId;
    private Long value;
    private Double valueInCurrency;
    private String currency;
    private Long wage;
    private Integer cards;
    private Integer goals;
    private Integer assists;
    private Integer matches;
    private Integer ntCards;
    private Integer ntGoals;
    private Integer ntAssists;
    private Integer ntMatches;
    private Integer injuryDays;
    private National national;

}
