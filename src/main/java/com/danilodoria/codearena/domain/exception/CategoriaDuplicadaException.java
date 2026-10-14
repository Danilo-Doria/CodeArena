package com.danilodoria.codearena.domain.exception;

public class CategoriaDuplicadaException extends DomainException {
    public CategoriaDuplicadaException(String nombre) {
        super("Ya existe una categoría con el nombre " + nombre);
    }
}