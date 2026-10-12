package com.danilodoria.codearena.application.port.in;

public interface ConsultarPerfilUseCase {
    PerfilUsuario consultarPerfil(Long usuarioId);
}