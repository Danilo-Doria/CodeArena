package com.danilodoria.codearena.domain.model;

public enum Nivel {
    ROOKIE(0),
    JUNIOR(500),
    DEVELOPER(1500),
    SENIOR(3000),
    MASTER(5000),
    LEGEND(10000);

    private final int experienciaMinima;

    Nivel(int experienciaMinima) {
        this.experienciaMinima = experienciaMinima;
    }

    public int getExperienciaMinima() {
        return experienciaMinima;
    }

    public static Nivel calcularSegunExperiencia(int experienciaAcumulada) {
        Nivel[] niveles = values();
        for (int i = niveles.length - 1; i >= 0; i--) {
            if (experienciaAcumulada >= niveles[i].experienciaMinima) {
                return niveles[i];
            }
        }
        return ROOKIE;
    }
}
