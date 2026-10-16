package com.danilodoria.codearena.domain.logro;

public class CincoMilXpAlcanzados implements ReglaLogro {
    @Override
    public String nombreLogro() {
        return "5000 XP alcanzados";
    }

    @Override
    public boolean seCumple(ContextoLogro contexto) {
        return contexto.usuario().getExperienciaAcumulada() >= 5000;
    }
}
