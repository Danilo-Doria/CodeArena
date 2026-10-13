package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.Participacion;
import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;

public interface ConsultarParticipacionesUseCase {
    ResultadoPaginado<Participacion> consultarParticipaciones(Long usuarioId, PaginaSolicitud solicitud);
    ResultadoPaginado<Participacion> consultarParticipacionesActivas(Long usuarioId, PaginaSolicitud solicitud);
    ResultadoPaginado<Participacion> consultarParticipacionesCompletadas(Long usuarioId, PaginaSolicitud solicitud);
}
