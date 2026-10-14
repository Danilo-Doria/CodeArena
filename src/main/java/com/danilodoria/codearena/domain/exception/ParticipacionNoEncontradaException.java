package com.danilodoria.codearena.domain.exception;

public class ParticipacionNoEncontradaException extends DomainException {
    public ParticipacionNoEncontradaException(Long usuarioId, Long retoId) {
        super("El usuario " + usuarioId + " no tiene una participación activa en el reto " + retoId);
    }
}