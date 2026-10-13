package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.RegistrarUsuarioComando;
import com.danilodoria.codearena.application.port.in.RegistrarUsuarioUseCase;
import com.danilodoria.codearena.application.port.out.PasswordEncoderPort;
import com.danilodoria.codearena.application.port.out.UsuarioRepositoryPort;
import com.danilodoria.codearena.domain.exception.EmailDuplicadoException;
import com.danilodoria.codearena.domain.exception.UsernameDuplicadoException;
import com.danilodoria.codearena.domain.model.Rol;
import com.danilodoria.codearena.domain.model.Usuario;

public class RegistrarUsuarioService implements RegistrarUsuarioUseCase {
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;

    public RegistrarUsuarioService(UsuarioRepositoryPort usuarioRepositoryPort,
                                   PasswordEncoderPort passwordEncoderPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.passwordEncoderPort = passwordEncoderPort;
    }

    @Override
    public Usuario registrarUsuario(RegistrarUsuarioComando comando) {
        if (usuarioRepositoryPort.existePorEmail(comando.email())) {
            throw new EmailDuplicadoException(comando.email());
        }
        if (usuarioRepositoryPort.existePorUsername(comando.username())) {
            throw new UsernameDuplicadoException(comando.username());
        }

        String passwordEncriptada = passwordEncoderPort.encriptar(comando.password());

        Usuario usuario = new Usuario(
                comando.nombre(),
                comando.username(),
                comando.email(),
                passwordEncriptada,
                Rol.PLAYER
        );

        return usuarioRepositoryPort.guardar(usuario);
    }
}