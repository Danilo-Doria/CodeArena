package com.danilodoria.codearena.application.port.out;

public interface PasswordEncoderPort {
    String encriptar(String passwordPlano);
    boolean coincide(String passwordPlano, String passwordHasheado);
}
