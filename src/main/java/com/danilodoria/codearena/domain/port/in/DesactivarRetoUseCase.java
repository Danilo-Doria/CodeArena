package com.danilodoria.codearena.domain.port.in;

import com.danilodoria.codearena.domain.model.Reto;

public interface DesactivarRetoUseCase {
    Reto desactivarReto(Long retoId);
}
