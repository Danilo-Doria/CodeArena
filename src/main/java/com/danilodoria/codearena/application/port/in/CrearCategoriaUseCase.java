package com.danilodoria.codearena.application.port.in;

import com.danilodoria.codearena.domain.model.Categoria;

public interface CrearCategoriaUseCase {
    Categoria crearCategoria(String nombre);
}
