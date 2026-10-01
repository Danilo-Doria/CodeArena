package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.Reto;

public interface CrearRetoUseCase {
    Reto crearReto(CrearRetoComando crearRetoComando);
}
