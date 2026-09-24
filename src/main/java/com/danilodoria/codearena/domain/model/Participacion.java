package com.danilodoria.codearena.domain.model;

import java.time.LocalDateTime;

public class Participacion {
    private Usuario usuario;
    private Reto reto;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaEntrga;
    private EstadoParticipacion estadoParticipacion;
    private String solucionEnviada;
}
