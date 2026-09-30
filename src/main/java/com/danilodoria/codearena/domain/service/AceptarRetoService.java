package com.danilodoria.codearena.domain.service;

import com.danilodoria.codearena.domain.exception.ParticipacionDuplicadaException;
import com.danilodoria.codearena.domain.exception.RetoNoEncontradoException;
import com.danilodoria.codearena.domain.exception.UsuarioNoEncontradoException;
import com.danilodoria.codearena.domain.model.Participacion;
import com.danilodoria.codearena.domain.model.Reto;
import com.danilodoria.codearena.domain.model.Usuario;
import com.danilodoria.codearena.domain.port.in.AceptarRetoUseCase;
import com.danilodoria.codearena.domain.port.out.ParticipacionRepositoryPort;
import com.danilodoria.codearena.domain.port.out.RetoRepositoryPort;
import com.danilodoria.codearena.domain.port.out.UsuarioRepositoryPort;

public class AceptarRetoService implements AceptarRetoUseCase {
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final RetoRepositoryPort retoRepositoryPort;
    private final ParticipacionRepositoryPort participacionRepositoryPort;

    public AceptarRetoService(
            UsuarioRepositoryPort usuarioRepositoryPort,
            RetoRepositoryPort retoRepositoryPort,
            ParticipacionRepositoryPort participacionRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.retoRepositoryPort = retoRepositoryPort;
        this.participacionRepositoryPort = participacionRepositoryPort;
    }

    @Override
    public Participacion aceptarReto(Long usuarioId, Long retoId) {
        Usuario usuario = usuarioRepositoryPort.buscarPorId(usuarioId)
                .orElseThrow(() -> new UsuarioNoEncontradoException(usuarioId));

        Reto reto = retoRepositoryPort.buscarPorId(retoId)
                .orElseThrow(() -> new RetoNoEncontradoException(retoId));

        if (participacionRepositoryPort.existeParticipacionActiva(usuarioId, retoId)) {
            throw new ParticipacionDuplicadaException(usuarioId, retoId);
        }

        // El constructor de Participacion valida internamente reto.puedeAceptarse()
        // y lanza IllegalStateException si el reto está inactivo o vencido.
        Participacion participacion = new Participacion(usuario, reto);

        return participacionRepositoryPort.guardar(participacion);
    }
}
