package com.danilodoria.codearena.domain.port.in;

import com.danilodoria.codearena.domain.model.Participacion;

public interface AceptarRetoUseCase {
    Participacion aceptarReto(Long usuarioId, Long retoId);
}
