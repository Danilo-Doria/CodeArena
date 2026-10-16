package com.danilodoria.codearena.domain.experiencia;

public class ExperienciaTriple implements EstrategiaExperiencia {
    @Override
    public int calcular(int experienciaBase) {
        return experienciaBase * 3;
    }
}
