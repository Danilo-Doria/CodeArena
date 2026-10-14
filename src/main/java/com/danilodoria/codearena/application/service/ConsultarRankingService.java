package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.ConsultarRankingUseCase;
import com.danilodoria.codearena.application.port.out.RankingRepositoryPort;
import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.RankingEntry;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;

public class ConsultarRankingService implements ConsultarRankingUseCase {
    RankingRepositoryPort rankingRepositoryPort;

    public ConsultarRankingService(RankingRepositoryPort rankingRepositoryPort) {
        this.rankingRepositoryPort = rankingRepositoryPort;
    }

    @Override
    public ResultadoPaginado<RankingEntry> consultarRankingGeneral(PaginaSolicitud solicitud) {
        return rankingRepositoryPort.obtenerRankingGeneral(solicitud);
    }

    @Override
    public RankingEntry consultarPosicionUsuario(Long usuarioId) {
        RankingEntry posicionUsuario = obtenerPosicionUsuario(usuarioId);
        return posicionUsuario;
    }
}
