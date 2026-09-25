package com.danilodoria.codearena.domain.port.out;

import com.danilodoria.codearena.domain.model.Usuario;
import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;

import java.util.Optional;

public interface UsuarioRepositoryPort {
    Usuario guardar(Usuario usuario);

    Optional<Usuario> buscarPorId(Long id);

    Optional<Usuario> buscarPorEmail(String email);

    Optional<Usuario> buscarPorUsername(String username);

    boolean existePorEmail(String email);

    boolean existePorUsername(String username);

    ResultadoPaginado<Usuario> buscarTodos(PaginaSolicitud solicitud);
}
