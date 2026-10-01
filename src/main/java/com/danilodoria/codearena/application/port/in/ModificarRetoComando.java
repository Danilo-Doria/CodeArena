package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.Dificultad;

import java.time.LocalDateTime;

public record ModificarRetoComando(
        Long retoId,
        String titulo,
        String descripcion,
        Long categoriaId,
        Dificultad dificultad,
        LocalDateTime fechaLimite
) {}
