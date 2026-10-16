package com.danilodoria.codearena.infrastructure.adapter.out.persistence.mapper;

import com.danilodoria.codearena.domain.model.Usuario;
import com.danilodoria.codearena.infrastructure.adapter.out.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(usuario.getId());
        entity.setNombre(usuario.getNombre());
        entity.setUsername(usuario.getUsername());
        entity.setEmail(usuario.getEmail());
        entity.setPassword(usuario.getPassword());
        entity.setRol(usuario.getRol());
        entity.setNivel(usuario.getNivel());
        entity.setExperienciaAcumulada(usuario.getExperienciaAcumulada());
        entity.setEstado(usuario.getEstado());
        return entity;
    }

    public Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getNombre(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRol(),
                entity.getNivel(),
                entity.getExperienciaAcumulada(),
                entity.getEstado()
        );
    }
}