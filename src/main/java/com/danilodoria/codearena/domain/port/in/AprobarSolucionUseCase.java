package com.danilodoria.codearena.domain.port.in;

import com.danilodoria.codearena.domain.model.Participacion;

public interface AprobarSolucionUseCase {
    Participacion aprobarSolucion(Long participacionId);
}
