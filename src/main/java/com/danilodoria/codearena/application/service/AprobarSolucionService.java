package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.AprobarSolucionUseCase;
import com.danilodoria.codearena.application.port.out.LogroObtenidoRepositoryPort;
import com.danilodoria.codearena.application.port.out.LogroRepositoryPort;
import com.danilodoria.codearena.application.port.out.ParticipacionRepositoryPort;
import com.danilodoria.codearena.application.port.out.UsuarioRepositoryPort;
import com.danilodoria.codearena.domain.exception.ParticipacionNoEncontradaException;
import com.danilodoria.codearena.domain.experiencia.EstrategiaExperiencia;
import com.danilodoria.codearena.domain.logro.ContextoLogro;
import com.danilodoria.codearena.domain.logro.ReglaLogro;
import com.danilodoria.codearena.domain.model.Logro;
import com.danilodoria.codearena.domain.model.LogroObtenido;
import com.danilodoria.codearena.domain.model.Participacion;
import com.danilodoria.codearena.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public class AprobarSolucionService implements AprobarSolucionUseCase {
    private final ParticipacionRepositoryPort participacionRepositoryPort;
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final LogroObtenidoRepositoryPort logroObtenidoRepositoryPort;
    private final LogroRepositoryPort logroRepositoryPort;
    private final EstrategiaExperiencia estrategiaExperiencia;
    private final List<ReglaLogro> reglas;

    public AprobarSolucionService(
            ParticipacionRepositoryPort participacionRepositoryPort,
            UsuarioRepositoryPort usuarioRepositoryPort,
            LogroObtenidoRepositoryPort logroObtenidoRepositoryPort,
            LogroRepositoryPort logroRepositoryPort,
            EstrategiaExperiencia estrategiaExperiencia,
            List<ReglaLogro> reglas) {
        this.participacionRepositoryPort = participacionRepositoryPort;
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.logroObtenidoRepositoryPort = logroObtenidoRepositoryPort;
        this.logroRepositoryPort = logroRepositoryPort;
        this.estrategiaExperiencia = estrategiaExperiencia;
        this.reglas = reglas;
    }

    @Override
    public Participacion aprobarSolucion(Long participacionId) {
        Participacion participacion = participacionRepositoryPort.buscarPorId(participacionId)
                .orElseThrow(() -> new ParticipacionNoEncontradaException(participacionId));

        Usuario usuario = participacion.getUsuario();

        int experiencia = estrategiaExperiencia.calcular(participacion.getReto().getExperienciaOtorgada());

        participacion.aprobar(experiencia);
        usuario.sumarExperiencia(experiencia);

        Participacion aprobada = participacionRepositoryPort.guardar(participacion);
        usuarioRepositoryPort.guardar(usuario);

        otorgarLogros(usuario, aprobada);

        return aprobada;
    }

    private void otorgarLogros(Usuario usuario, Participacion participacion) {
        long retosCompletados = participacionRepositoryPort.contarCompletadasPorUsuario(usuario.getId());
        ContextoLogro contexto = new ContextoLogro(usuario, participacion, retosCompletados);

        for (ReglaLogro regla : reglas) {
            if (!regla.seCumple(contexto)) {
                continue;
            }

            Optional<Logro> logro = logroRepositoryPort.buscarPorNombre(regla.nombreLogro());
            if (logro.isEmpty()) {
                continue;
            }

            if (logroObtenidoRepositoryPort.existeLogroObtenido(usuario.getId(), logro.get().getId())) {
                continue;
            }

            logroObtenidoRepositoryPort.guardar(new LogroObtenido(usuario, logro.get()));
        }
    }
}
