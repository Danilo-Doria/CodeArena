package com.danilodoria.codearena.domain.port.in;

import com.danilodoria.codearena.domain.model.Participacion;

public interface RechazarSolucionUseCase {
    Participacion rechazarSolucion(Long participacionId);
}
