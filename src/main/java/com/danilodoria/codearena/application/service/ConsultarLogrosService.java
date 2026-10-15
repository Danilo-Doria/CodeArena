package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.ConsultarLogrosUseCase;
import com.danilodoria.codearena.application.port.out.LogroObtenidoRepositoryPort;
import com.danilodoria.codearena.domain.model.LogroObtenido;

import java.util.List;

public class ConsultarLogrosService implements ConsultarLogrosUseCase {
    private final LogroObtenidoRepositoryPort logroObtenidoRepositoryPort;

    public ConsultarLogrosService(LogroObtenidoRepositoryPort logroObtenidoRepositoryPort) {
        this.logroObtenidoRepositoryPort = logroObtenidoRepositoryPort;
    }

    @Override
    public List<LogroObtenido> consultarLogros(Long usuarioId) {
        return logroObtenidoRepositoryPort.buscarPorUsuario(usuarioId);
    }
}
