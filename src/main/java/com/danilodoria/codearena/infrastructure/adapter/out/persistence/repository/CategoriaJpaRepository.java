package com.danilodoria.codearena.infrastructure.adapter.out.persistence.repository;

import com.danilodoria.codearena.infrastructure.adapter.out.persistence.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Long> {
    Optional<CategoriaEntity> findByNombreIgnoreCase(String username);
    boolean existsByNombreIgnoreCase(String username);
}
