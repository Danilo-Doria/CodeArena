package com.danilodoria.codearena.domain.exception;

public class RetoVencidoException extends DomainException {
    public RetoVencidoException(Long retoId) {
        super("El reto con id " + retoId + " ya venció y no puede aceptarse");
    }
}
