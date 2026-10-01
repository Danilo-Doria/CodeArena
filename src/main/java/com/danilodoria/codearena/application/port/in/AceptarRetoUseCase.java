package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.Participacion;

public interface AceptarRetoUseCase {
    Participacion aceptarReto(Long usuarioId, Long retoId);
}
