package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.CrearCategoriaUseCase;
import com.danilodoria.codearena.application.port.out.CategoriaRepositoryPort;
import com.danilodoria.codearena.domain.exception.CategoriaDuplicadaException;
import com.danilodoria.codearena.domain.model.Categoria;

public class CrearCategoriaService implements CrearCategoriaUseCase {

    private final CategoriaRepositoryPort categoriaRepositoryPort;

    public CrearCategoriaService(CategoriaRepositoryPort categoriaRepositoryPort) {
        this.categoriaRepositoryPort = categoriaRepositoryPort;
    }

    @Override
    public Categoria crearCategoria(String nombre) {
        Categoria categoria = new Categoria(nombre);

        if (categoriaRepositoryPort.existePorNombre(categoria.getNombre())) {
            throw new CategoriaDuplicadaException(categoria.getNombre());
        }

        return categoriaRepositoryPort.guardar(categoria);
    }
}