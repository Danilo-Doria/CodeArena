package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.Nivel;
import com.danilodoria.codearena.domain.model.Rol;

public record ResultadoAutenticacion(
        String token,
        Long usuarioId,
        String nombre,
        String username,
        Rol rol,
        Nivel nivel
) {}
