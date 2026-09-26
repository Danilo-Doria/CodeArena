package com.danilodoria.codearena.domain.port.in;

import com.danilodoria.codearena.domain.model.Reto;

public interface CrearRetoUseCase {
    Reto crearReto(CrearRetoComando crearRetoComando);
}
