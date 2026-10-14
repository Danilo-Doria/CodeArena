package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.ModificarRetoComando;
import com.danilodoria.codearena.application.port.in.ModificarRetoUseCase;
import com.danilodoria.codearena.application.port.out.CategoriaRepositoryPort;
import com.danilodoria.codearena.application.port.out.RetoRepositoryPort;
import com.danilodoria.codearena.domain.exception.CategoriaNoEncontradaException;
import com.danilodoria.codearena.domain.exception.RetoNoEncontradoException;
import com.danilodoria.codearena.domain.model.Categoria;
import com.danilodoria.codearena.domain.model.Reto;

public class ModificarRetoService implements ModificarRetoUseCase {
    private final RetoRepositoryPort retoRepositoryPort;
    private final CategoriaRepositoryPort categoriaRepositoryPort;

    public ModificarRetoService(RetoRepositoryPort retoRepositoryPort, CategoriaRepositoryPort categoriaRepositoryPort) {
        this.retoRepositoryPort = retoRepositoryPort;
        this.categoriaRepositoryPort = categoriaRepositoryPort;
    }

    @Override
    public Reto modificarReto(ModificarRetoComando comando) {
        Reto reto = retoRepositoryPort.buscarPorId(comando.retoId())
                .orElseThrow(() -> new RetoNoEncontradoException(comando.retoId()));

        Categoria categoria = categoriaRepositoryPort.buscarPorId(comando.categoriaId())
                .orElseThrow(() -> new CategoriaNoEncontradaException(comando.categoriaId()));

        reto.actualizarDatos(
                comando.titulo(),
                comando.descripcion(),
                categoria,
                comando.dificultad(),
                comando.fechaLimite());

        return retoRepositoryPort.guardar(reto);
    }
}
