package com.danilodoria.codearena.domain.exception;

public class UsuarioNoEncontradoException extends DomainException {
    public UsuarioNoEncontradoException(Long usuarioId) {
        super("No se encontró el usuario con id " + usuarioId);
    }
}
