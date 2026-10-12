package com.danilodoria.codearena.domain.model.utils;

import com.danilodoria.codearena.domain.model.Nivel;

public record RankingEntry(
        int posicion,
        String username,
        Nivel nivel,
        int experienciaAcumulada,
        int retosCompletados
) {}