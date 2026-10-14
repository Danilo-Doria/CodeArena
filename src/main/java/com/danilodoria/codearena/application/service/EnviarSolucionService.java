package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.EnviarSolucionUseCase;
import com.danilodoria.codearena.application.port.out.ParticipacionRepositoryPort;
import com.danilodoria.codearena.domain.exception.ParticipacionNoEncontradaException;
import com.danilodoria.codearena.domain.model.Participacion;

public class EnviarSolucionService implements EnviarSolucionUseCase {
    private final ParticipacionRepositoryPort participacionRepositoryPort;

    public EnviarSolucionService(ParticipacionRepositoryPort participacionRepositoryPort) {
        this.participacionRepositoryPort = participacionRepositoryPort;
    }

    @Override
    public Participacion enviarSolucion(Long usuarioId, Long retoId, String solucion) {
        Participacion participacion = participacionRepositoryPort.buscarParticipacionActiva(usuarioId, retoId)
                .orElseThrow(() -> new ParticipacionNoEncontradaException(usuarioId, retoId));

        participacion.enviarSolucion(solucion);

        return participacionRepositoryPort.guardar(participacion);
    }
}
