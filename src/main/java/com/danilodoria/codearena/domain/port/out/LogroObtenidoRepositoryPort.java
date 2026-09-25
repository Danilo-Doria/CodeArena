package com.danilodoria.codearena.domain.port.out;

import com.danilodoria.codearena.domain.model.LogroObtenido;

import java.util.List;

public interface LogroObtenidoRepositoryPort {
    LogroObtenido guardar(LogroObtenido logroObtenido);
    boolean existeLogroObtenido(Long usuarioId, Long logroId);
    List<LogroObtenido> buscarPorUsuario(Long usuarioId);
}
