package com.danilodoria.codearena.domain.logro;

import com.danilodoria.codearena.domain.model.Dificultad;

public class RetoLegendaryCompletado implements ReglaLogro {

    @Override
    public String nombreLogro() {
        return "Reto LEGENDARY completado";
    }

    @Override
    public boolean seCumple(ContextoLogro contexto) {
        return contexto.participacion().getReto().getDificultad() == Dificultad.LEGENDARY;
    }
}