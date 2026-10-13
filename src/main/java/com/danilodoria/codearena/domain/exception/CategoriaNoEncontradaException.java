package com.danilodoria.codearena.domain.exception;

public class CategoriaNoEncontradaException extends DomainException {
    public CategoriaNoEncontradaException(Long categoriaId) {
        super("No se encontró la categoría con id " + categoriaId);
    }
}