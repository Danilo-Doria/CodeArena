package com.danilodoria.codearena.domain.exception;

public class CredencialesInvalidasException extends DomainException {
    public CredencialesInvalidasException() {
        super("Credenciales incorrectas");
    }
}