package com.estivy.sokkerarchitect.core.domain;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum National {
    NONE(0), SENIOR(1), U21(2);

    private final int value;


    National(int value) {
        this.value = value;
    }

    public static National fromValue(int value){
        return Arrays.stream(National.values())
                .filter(n -> n.getValue() == value)
                .findFirst().orElse(NONE);
    }
}
