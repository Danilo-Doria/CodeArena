package com.danilodoria.codearena.application.service;


import com.danilodoria.codearena.application.port.in.ActivarRetoUseCase;
import com.danilodoria.codearena.application.port.out.RetoRepositoryPort;
import com.danilodoria.codearena.domain.exception.RetoNoEncontradoException;
import com.danilodoria.codearena.domain.model.Reto;

public class ActivarRetoService implements ActivarRetoUseCase {
    private final RetoRepositoryPort retoRepositoryPort;

    public ActivarRetoService(RetoRepositoryPort retoRepositoryPort) {
        this.retoRepositoryPort = retoRepositoryPort;
    }

    @Override
    public Reto activarReto(Long retoId) {
        Reto reto = retoRepositoryPort.buscarPorId(retoId)
                .orElseThrow(() -> new RetoNoEncontradoException(retoId));
        reto.activar();
        return retoRepositoryPort.guardar(reto);
    }
}
