package com.danilodoria.codearena.domain.logro;

public class DiezRetosCompletado implements ReglaLogro {

    @Override
    public String nombreLogro() {
        return "Primer reto completado";
    }

    @Override
    public boolean seCumple(ContextoLogro contexto) {
        return contexto.retosCompletados() >= 10;
    }
}
