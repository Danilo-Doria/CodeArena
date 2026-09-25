package com.danilodoria.codearena.domain.port.out;

import com.danilodoria.codearena.domain.model.Logro;

import java.util.List;
import java.util.Optional;

public interface LogroRepositoryPort {
    Logro guardar(Logro logro);

    Optional<Logro> buscarPorId(Long id);

    Optional<Logro> buscarPorNombre(String nombre);

    boolean existePorNombre(String nombre);

    List<Logro> buscarTodos();
}
