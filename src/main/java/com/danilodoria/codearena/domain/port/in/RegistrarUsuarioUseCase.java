package com.danilodoria.codearena.domain.port.in;

import com.danilodoria.codearena.domain.model.Rol;
import com.danilodoria.codearena.domain.model.Usuario;

public interface RegistrarUsuarioUseCase {
    Usuario registrarUsuario(RegistrarUsuarioComando registrarUsuarioComando);
}
