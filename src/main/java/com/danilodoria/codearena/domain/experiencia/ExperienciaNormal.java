package com.danilodoria.codearena.domain.experiencia;

public class ExperienciaNormal implements EstrategiaExperiencia {
    @Override
    public int calcular(int experienciaBase) {
        return experienciaBase;
    }
}