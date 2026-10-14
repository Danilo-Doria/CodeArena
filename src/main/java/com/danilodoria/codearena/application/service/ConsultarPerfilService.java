package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.ConsultarPerfilUseCase;
import com.danilodoria.codearena.application.port.in.PerfilUsuario;
import com.danilodoria.codearena.application.port.out.ParticipacionRepositoryPort;
import com.danilodoria.codearena.application.port.out.UsuarioRepositoryPort;
import com.danilodoria.codearena.domain.exception.UsuarioNoEncontradoException;
import com.danilodoria.codearena.domain.model.Usuario;

public class ConsultarPerfilService implements ConsultarPerfilUseCase {
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final ParticipacionRepositoryPort participacionRepositoryPort;

    public ConsultarPerfilService(UsuarioRepositoryPort usuarioRepositoryPort, ParticipacionRepositoryPort participacionRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.participacionRepositoryPort = participacionRepositoryPort;
    }

    @Override
    public PerfilUsuario consultarPerfil(Long usuarioId) {
        Usuario usuario = usuarioRepositoryPort.buscarPorId(usuarioId)
                .orElseThrow(() -> new UsuarioNoEncontradoException(usuarioId));

        long retosCompletados = participacionRepositoryPort.contarCompletadasPorUsuario(usuarioId);

        return new PerfilUsuario(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getRol(),
                usuario.getNivel(),
                usuario.getExperienciaAcumulada(),
                retosCompletados,
                usuario.getEstado()
        );
    }
}
