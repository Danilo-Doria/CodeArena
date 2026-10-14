package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.ConsultarRetosUseCase;
import com.danilodoria.codearena.application.port.out.RetoRepositoryPort;
import com.danilodoria.codearena.domain.model.Dificultad;
import com.danilodoria.codearena.domain.model.Reto;
import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;

import java.time.LocalDateTime;

public class ConsultarRetosService implements ConsultarRetosUseCase {
    private static final int DIAS_PROXIMO_A_VENCER = 3;
    private final RetoRepositoryPort retoRepositoryPort;

    public ConsultarRetosService(RetoRepositoryPort retoRepositoryPort) {
        this.retoRepositoryPort = retoRepositoryPort;
    }

    @Override
    public ResultadoPaginado<Reto> consultarRetosDisponibles(PaginaSolicitud solicitud) {
        return retoRepositoryPort.buscarTodosActivos(solicitud);
    }

    @Override
    public ResultadoPaginado<Reto> consultarRetosPorDificultad(Dificultad dificultad, PaginaSolicitud solicitud) {
        return retoRepositoryPort.buscarPorDificultad(dificultad, solicitud);
    }

    @Override
    public ResultadoPaginado<Reto> consultarRetosPorCategoria(Long categoriaId, PaginaSolicitud solicitud) {
        return retoRepositoryPort.buscarPorCategoria(categoriaId, solicitud);
    }

    @Override
    public ResultadoPaginado<Reto> consultarProximosAVencer(PaginaSolicitud solicitud) {
        LocalDateTime limite = LocalDateTime.now().plusDays(DIAS_PROXIMO_A_VENCER);
        return retoRepositoryPort.buscarProximosAVencer(limite, solicitud);
    }
}