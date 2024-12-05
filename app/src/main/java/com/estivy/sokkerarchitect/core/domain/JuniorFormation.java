package com.estivy.sokkerarchitect.core.domain;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum JuniorFormation {
    GOALKEEPER(0), FIELD_PLAYER(1);

    private final int value;

    JuniorFormation(int value) {
        this.value = value;
    }

    public static JuniorFormation fromValue(int value) {
        return Arrays.stream(JuniorFormation.values())
                .filter(n -> n.getValue() == value)
                .findFirst().orElse(FIELD_PLAYER);
    }
}
