package com.danilodoria.codearena.domain.exception;

public abstract class DomainException extends RuntimeException {
    protected DomainException(String mensaje) {
        super(mensaje);
    }
}
