package com.danilodoria.codearena.domain.port.out;

public interface PasswordEncoderPort {
    String encriptar(String passwordPlano);
    boolean coincide(String passwordPlano, String passwordHasheado);
}
