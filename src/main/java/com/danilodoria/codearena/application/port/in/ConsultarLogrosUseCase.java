package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.LogroObtenido;

import java.util.List;

public interface ConsultarLogrosUseCase {
    List<LogroObtenido> consultarLogros(Long usuarioId);
}