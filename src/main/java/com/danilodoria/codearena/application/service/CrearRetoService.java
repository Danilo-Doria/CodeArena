package com.danilodoria.codearena.application.service;

import com.danilodoria.codearena.application.port.in.CrearRetoComando;
import com.danilodoria.codearena.application.port.in.CrearRetoUseCase;
import com.danilodoria.codearena.application.port.out.CategoriaRepositoryPort;
import com.danilodoria.codearena.application.port.out.RetoRepositoryPort;
import com.danilodoria.codearena.domain.exception.CategoriaNoEncontradaException;
import com.danilodoria.codearena.domain.model.Categoria;
import com.danilodoria.codearena.domain.model.Reto;

public class CrearRetoService implements CrearRetoUseCase {
    private final RetoRepositoryPort retoRepositoryPort;
    private final CategoriaRepositoryPort categoriaRepositoryPort;

    public CrearRetoService(RetoRepositoryPort retoRepositoryPort, CategoriaRepositoryPort categoriaRepositoryPort) {
        this.retoRepositoryPort = retoRepositoryPort;
        this.categoriaRepositoryPort = categoriaRepositoryPort;
    }

    @Override
    public Reto crearReto(CrearRetoComando comando) {
        Categoria categoria = categoriaRepositoryPort.buscarPorId(comando.categoriaId())
                .orElseThrow(() -> new CategoriaNoEncontradaException(comando.categoriaId()));

        Reto reto = new Reto(
                comando.titulo(),
                comando.descripcion(),
                categoria,
                comando.dificultad(),
                comando.fechaLimite()
        );

        return retoRepositoryPort.guardar(reto);
    }
}
