package com.danilodoria.codearena.domain.exception;

public class ParticipacionDuplicadaException extends DomainException {
    public ParticipacionDuplicadaException(Long  usuarioId, Long retoId) {
        super("El usuario " + usuarioId + " ya tiene una participación activa en el reto " + retoId);
    }
}
