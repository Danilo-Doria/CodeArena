package com.danilodoria.codearena.infrastructure.adapter.out.persistence.mapper;

import com.danilodoria.codearena.domain.model.Usuario;
import com.danilodoria.codearena.infrastructure.adapter.out.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario) {
        return UsuarioEntity.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .password(usuario.getPassword())
                .rol(usuario.getRol())
                .nivel(usuario.getNivel())
                .experienciaAcumulada(usuario.getExperienciaAcumulada())
                .estado(usuario.getEstado())
                .build();
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