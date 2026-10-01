package com.danilodoria.codearena.application.port.in;

public interface AutenticarUsuarioUseCase {
    ResultadoAutenticacion autenticarUsuario(String email, String password);
}
