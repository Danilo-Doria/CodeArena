package com.danilodoria.codearena.domain.exception;

public class UsernameDuplicadoException extends DomainException {
    public UsernameDuplicadoException(String username) {
        super("Ya existe un usuario con el username " + username);
    }
}