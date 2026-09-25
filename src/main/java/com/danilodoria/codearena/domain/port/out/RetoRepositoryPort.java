package com.danilodoria.codearena.domain.port.out;

import com.danilodoria.codearena.domain.model.Dificultad;
import com.danilodoria.codearena.domain.model.Reto;
import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RetoRepositoryPort {
    Reto guardar(Reto reto);
    Optional<Reto> buscarPorId(Long id);
    ResultadoPaginado<Reto> buscarTodos(PaginaSolicitud solicitud);
    ResultadoPaginado<Reto> buscarTodosActivos(PaginaSolicitud solicitud);
    ResultadoPaginado<Reto> buscarPorDificultad(Dificultad dificultad, PaginaSolicitud solicitud);
    ResultadoPaginado<Reto> buscarPorCategoria(Long categoriaId, PaginaSolicitud solicitud);
    ResultadoPaginado<Reto> buscarProximosAVencer(LocalDateTime antesDe, PaginaSolicitud solicitud);
}
