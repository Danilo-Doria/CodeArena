package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.Participacion;

public interface EnviarSolucionUseCase {
    Participacion enviarSolucion(Long usuarioId, Long retoId, String solucion);
}
