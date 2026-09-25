package com.danilodoria.codearena.domain.port.out;

import com.danilodoria.codearena.domain.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepositoryPort {
    Categoria guardar(Categoria categoria);

    Optional<Categoria> buscarPorId(Long id);

    Optional<Categoria> buscarPorNombre(String nombre);

    boolean existePorNombre(String nombre);

    List<Categoria> buscarTodos();
}
