package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.RankingEntry;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;

public interface ConsultarRankingUseCase {
    ResultadoPaginado<RankingEntry> consultarRankingGeneral(PaginaSolicitud solicitud);
    RankingEntry consultarPosicionUsuario(Long usuarioId);
}