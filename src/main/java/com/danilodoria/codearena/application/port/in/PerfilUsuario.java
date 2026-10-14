package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.EstadoUsuario;
import com.danilodoria.codearena.domain.model.Nivel;
import com.danilodoria.codearena.domain.model.Rol;

public record PerfilUsuario(
        Long id,
        String nombre,
        String username,
        String email,
        Rol rol,
        Nivel nivel,
        int experienciaAcumulada,
        long retosCompletados,
        EstadoUsuario estado
) {}
