package com.danilodoria.codearena.application.port.in;

public record RegistrarUsuarioComando(
        String nombre,
        String username,
        String email,
        String password
) {}
