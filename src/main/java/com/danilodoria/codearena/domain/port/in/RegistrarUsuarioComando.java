package com.danilodoria.codearena.domain.port.in;

import com.danilodoria.codearena.domain.model.Rol;

public record RegistrarUsuarioComando(
        String nombre,
        String username,
        String email,
        String password,
        Rol rol
) {}
