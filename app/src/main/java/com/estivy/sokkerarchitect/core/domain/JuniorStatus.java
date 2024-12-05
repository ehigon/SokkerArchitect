package com.estivy.sokkerarchitect.core.domain;

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
public class JuniorStatus {
    private Integer skill;
    private JuniorFormation formation;
    private Integer remainingWeeks;
    private Long week;
}
