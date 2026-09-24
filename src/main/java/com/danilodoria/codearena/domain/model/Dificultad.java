package com.danilodoria.codearena.domain.model;

public enum Dificultad {
    EASY(100),
    MEDIUM(250),
    HARD(500),
    LEGENDARY(1000);

    private final int experienciaOtorgada;

    Dificultad(int experienciaOtorgada) {
        this.experienciaOtorgada = experienciaOtorgada;
    }

    public int getExperienciaOtorgada() {
        return experienciaOtorgada;
    }
}
