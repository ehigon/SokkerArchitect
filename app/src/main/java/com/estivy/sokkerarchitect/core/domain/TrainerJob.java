package com.estivy.sokkerarchitect.core.domain;

public enum TrainerJob {
    PRINCIPAL(1), ASSISTANT(2), JUNIOR(3);

    private final int value;

    TrainerJob(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
