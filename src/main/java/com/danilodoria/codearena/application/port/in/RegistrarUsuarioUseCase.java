package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.Usuario;

public interface RegistrarUsuarioUseCase {
    Usuario registrarUsuario(RegistrarUsuarioComando registrarUsuarioComando);
}
