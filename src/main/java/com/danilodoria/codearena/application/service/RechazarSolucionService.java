package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.RechazarSolucionUseCase;
import com.danilodoria.codearena.application.port.out.ParticipacionRepositoryPort;
import com.danilodoria.codearena.domain.exception.ParticipacionNoEncontradaException;
import com.danilodoria.codearena.domain.model.Participacion;

public class RechazarSolucionService implements RechazarSolucionUseCase {
    private final ParticipacionRepositoryPort participacionRepositoryPort;

    public RechazarSolucionService(ParticipacionRepositoryPort participacionRepositoryPort) {
        this.participacionRepositoryPort = participacionRepositoryPort;
    }

    @Override
    public Participacion rechazarSolucion(Long participacionId) {
        Participacion participacion = participacionRepositoryPort.buscarPorId(participacionId)
                .orElseThrow(() -> new ParticipacionNoEncontradaException(participacionId));

        participacion.rechazar();
        return participacionRepositoryPort.guardar(participacion);
    }
}
