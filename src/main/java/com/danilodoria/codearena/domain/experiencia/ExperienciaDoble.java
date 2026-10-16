package com.danilodoria.codearena.domain.experiencia;

public class ExperienciaDoble implements EstrategiaExperiencia {
    @Override
    public int calcular(int experienciaBase) {
        return experienciaBase * 2;
    }
}
