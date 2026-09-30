package com.danilodoria.codearena.domain.port.out;

import com.danilodoria.codearena.domain.model.Rol;

public interface TokenProviderPort {
    String generarToken(Long usuarioId, String username, Rol rol);
}
