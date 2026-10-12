package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.Dificultad;
import com.danilodoria.codearena.domain.model.Reto;
import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;

public interface ConsultarRetosUseCase {
    ResultadoPaginado<Reto> consultarRetosDisponibles(PaginaSolicitud solicitud);
    ResultadoPaginado<Reto> consultarRetosPorDificultad(Dificultad dificultad, PaginaSolicitud solicitud);
    ResultadoPaginado<Reto> consultarRetosPorCategoria(Long categoriaId, PaginaSolicitud solicitud);
    ResultadoPaginado<Reto> consultarProximosAVencer(PaginaSolicitud solicitud);
}
