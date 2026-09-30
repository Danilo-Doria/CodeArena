package com.danilodoria.codearena.domain.exception;

public class RetoNoEncontradoException extends DomainException {
    public RetoNoEncontradoException(Long retoId) {
        super("No se encontro el reto con id " + retoId);
    }
}
