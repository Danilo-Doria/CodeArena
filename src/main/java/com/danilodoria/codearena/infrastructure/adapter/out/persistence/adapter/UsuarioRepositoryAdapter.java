package com.danilodoria.codearena.infrastructure.adapter.out.persistence.adapter;

import com.danilodoria.codearena.application.port.out.UsuarioRepositoryPort;
import com.danilodoria.codearena.domain.model.Usuario;
import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;
import com.danilodoria.codearena.infrastructure.adapter.out.persistence.entity.UsuarioEntity;
import com.danilodoria.codearena.infrastructure.adapter.out.persistence.mapper.PaginacionMapper;
import com.danilodoria.codearena.infrastructure.adapter.out.persistence.mapper.UsuarioEntityMapper;
import com.danilodoria.codearena.infrastructure.adapter.out.persistence.repository.UsuarioJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository jpaRepository;
    private final UsuarioEntityMapper mapper;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository jpaRepository, UsuarioEntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity guardada = jpaRepository.save(mapper.toEntity(usuario));
        return mapper.toDomain(guardada);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return jpaRepository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return jpaRepository.findByUsername(username).map(mapper::toDomain);
    }

    @Override
    public boolean existePorEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existePorUsername(String username) {
        return jpaRepository.existsByUsername(username);
    }

    @Override
    public ResultadoPaginado<Usuario> buscarTodos(PaginaSolicitud solicitud) {
        Page<UsuarioEntity> page = jpaRepository.findAll(PaginacionMapper.toPageRequest(solicitud));
        return PaginacionMapper.toResultadoPaginado(page, mapper::toDomain);
    }
}