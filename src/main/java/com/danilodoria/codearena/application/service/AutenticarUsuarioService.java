package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.AutenticarUsuarioUseCase;
import com.danilodoria.codearena.application.port.in.ResultadoAutenticacion;
import com.danilodoria.codearena.application.port.out.PasswordEncoderPort;
import com.danilodoria.codearena.application.port.out.TokenProviderPort;
import com.danilodoria.codearena.application.port.out.UsuarioRepositoryPort;
import com.danilodoria.codearena.domain.exception.CredencialesInvalidasException;
import com.danilodoria.codearena.domain.model.EstadoUsuario;
import com.danilodoria.codearena.domain.model.Usuario;

public class AutenticarUsuarioService implements AutenticarUsuarioUseCase {
    private final PasswordEncoderPort passwordEncoderPort;
    private final TokenProviderPort tokenProviderPort;
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public AutenticarUsuarioService(
            PasswordEncoderPort passwordEncoderPort,
            TokenProviderPort tokenProviderPort,
            UsuarioRepositoryPort usuarioRepositoryPort) {
        this.passwordEncoderPort = passwordEncoderPort;
        this.tokenProviderPort = tokenProviderPort;
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public ResultadoAutenticacion autenticarUsuario(String email, String password) {
        Usuario usuario = usuarioRepositoryPort.buscarPorEmail(email)
                .orElseThrow(CredencialesInvalidasException::new);

        if (!passwordEncoderPort.coincide(password, usuario.getPassword())) {
            throw new CredencialesInvalidasException();
        }

        if (!usuario.estaActivo()) {
            throw new CredencialesInvalidasException();
        }

        String token = tokenProviderPort.generarToken(usuario.getId(), usuario.getUsername(), usuario.getRol());

        return new ResultadoAutenticacion(
                token,
                usuario.getId(),
                usuario.getNombre(),
                usuario.getUsername(),
                usuario.getRol(),
                usuario.getNivel());
    }
}
