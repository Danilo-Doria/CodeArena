package com.danilodoria.codearena.application.port.out;

import com.danilodoria.codearena.domain.model.utils.RankingEntry;
import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;

import java.util.Optional;

public interface RankingRepositoryPort {
    ResultadoPaginado<RankingEntry> obtenerRankingGeneral(PaginaSolicitud solicitud);
    Optional<RankingEntry> obtenerPosicionUsuario(Long usuarioId);
}