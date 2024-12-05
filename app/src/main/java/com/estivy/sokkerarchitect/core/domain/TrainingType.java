package com.estivy.sokkerarchitect.core.domain;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum TrainingType {

    GENERAL(0),
    STAMINA(1),
    KEEPER(2),
    PLAYMAKING(3),
    PASSING(4),
    TECHNIQUE(5),
    DEFENDING(6),
    SCORING(7),
    PACE(8);

    private final int value;

    TrainingType(int value) {
        this.value = value;
    }

    public static TrainingType fromValue(int value) {
        return Arrays.stream(TrainingType.values())
                .filter(n -> n.getValue() == value)
                .findFirst().orElse(GENERAL);
    }
}
