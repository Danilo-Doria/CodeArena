package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.ConsultarParticipacionesUseCase;
import com.danilodoria.codearena.application.port.out.ParticipacionRepositoryPort;
import com.danilodoria.codearena.application.port.out.UsuarioRepositoryPort;
import com.danilodoria.codearena.domain.model.Participacion;
import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;

public class ConsultarParticipacionesService implements ConsultarParticipacionesUseCase {
    private final ParticipacionRepositoryPort participacionRepositoryPort;

    public ConsultarParticipacionesService(ParticipacionRepositoryPort participacionRepositoryPort, UsuarioRepositoryPort usuarioRepositoryPort) {
        this.participacionRepositoryPort = participacionRepositoryPort;
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public ResultadoPaginado<Participacion> consultarParticipaciones(Long usuarioId, PaginaSolicitud solicitud) {
        return participacionRepositoryPort.buscarPorUsuario(usuarioId, solicitud);
    }

    @Override
    public ResultadoPaginado<Participacion> consultarParticipacionesActivas(Long usuarioId, PaginaSolicitud solicitud) {
        return participacionRepositoryPort.buscarPorUsuario(usuarioId, solicitud);
    }

    @Override
    public ResultadoPaginado<Participacion> consultarParticipacionesCompletadas(Long usuarioId, PaginaSolicitud solicitud) {
        return participacionRepositoryPort.buscarPorUsuario(usuarioId, solicitud);
    }
}
