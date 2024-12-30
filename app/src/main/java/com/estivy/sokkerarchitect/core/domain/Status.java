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
public class Status {

    private List<Player> players;

    private Long week;

    private List<Country> countries;

    private Team team;

}
