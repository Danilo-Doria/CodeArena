package com.danilodoria.codearena.domain.logro;

import com.danilodoria.codearena.domain.model.Participacion;
import com.danilodoria.codearena.domain.model.Usuario;

public record ContextoLogro(Usuario usuario, Participacion participacion, long retosCompletados) {
}
