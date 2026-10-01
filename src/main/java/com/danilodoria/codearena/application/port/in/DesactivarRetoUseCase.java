package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.Reto;

public interface DesactivarRetoUseCase {
    Reto desactivarReto(Long retoId);
}
