package com.danilodoria.codearena.domain.port.in;

import com.danilodoria.codearena.domain.model.Dificultad;

import java.time.LocalDateTime;

public record CrearRetoComando(
        String titulo,
        String descripcion,
        Long categoriaId,
        Dificultad dificultad,
        LocalDateTime fechaLimite
) {}
