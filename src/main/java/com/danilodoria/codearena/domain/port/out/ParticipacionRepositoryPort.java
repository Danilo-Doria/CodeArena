package com.danilodoria.codearena.domain.port.out;

import com.danilodoria.codearena.domain.model.Participacion;
import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;

import java.util.Optional;


public interface ParticipacionRepositoryPort {
    Participacion guardar(Participacion participacion);

    Optional<Participacion> buscarPorId(Long id);

    boolean existeParticipacionActiva(Long usuarioId, Long retoId);

    Optional<Participacion> buscarParticipacionActiva(Long usuarioId, Long retoId);

    ResultadoPaginado<Participacion> buscarPorUsuario(Long usuarioId, PaginaSolicitud solicitud);

    ResultadoPaginado<Participacion> buscarActivasPorUsuario(Long usuarioId, PaginaSolicitud solicitud);

    ResultadoPaginado<Participacion> buscarCompletadasPorUsuario(Long usuarioId, PaginaSolicitud solicitud);

    long contarCompletadasPorUsuario(Long usuarioId);

}
