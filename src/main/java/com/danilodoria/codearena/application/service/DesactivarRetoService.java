package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.DesactivarRetoUseCase;
import com.danilodoria.codearena.application.port.out.RetoRepositoryPort;
import com.danilodoria.codearena.domain.exception.RetoNoEncontradoException;
import com.danilodoria.codearena.domain.model.Reto;

public class DesactivarRetoService implements DesactivarRetoUseCase {
    private final RetoRepositoryPort retoRepositoryPort;

    public DesactivarRetoService(RetoRepositoryPort retoRepositoryPort) {
        this.retoRepositoryPort = retoRepositoryPort;
    }

    @Override
    public Reto desactivarReto(Long retoId) {
        Reto reto = retoRepositoryPort.buscarPorId(retoId)
                .orElseThrow(() -> new RetoNoEncontradoException(retoId));
        reto.desactivar();
        return retoRepositoryPort.guardar(reto);
    }
}
