package com.danilodoria.codearena.domain.port.in;

public interface AutenticarUsuarioUseCase {
    ResultadoAutenticacion autenticarUsuario(String email, String password);
}
