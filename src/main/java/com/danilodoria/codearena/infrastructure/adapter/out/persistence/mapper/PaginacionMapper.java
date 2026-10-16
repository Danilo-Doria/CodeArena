package com.danilodoria.codearena.infrastructure.adapter.out.persistence.mapper;

import com.danilodoria.codearena.domain.model.utils.PaginaSolicitud;
import com.danilodoria.codearena.domain.model.utils.ResultadoPaginado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.function.Function;

public final class PaginacionMapper {

    private PaginacionMapper() {
    }

    public static PageRequest toPageRequest(PaginaSolicitud solicitud) {
        // Sin ORDER BY, PostgreSQL no garantiza el orden entre páginas
        return PageRequest.of(solicitud.pagina(), solicitud.tamano(), Sort.by("id"));
    }

    public static <E, D> ResultadoPaginado<D> toResultadoPaginado(Page<E> page, Function<E, D> mapper) {
        List<D> contenido = page.getContent().stream().map(mapper).toList();
        return new ResultadoPaginado<>(
                contenido,
                page.getNumber(),
                page.getTotalPages(),
                page.getTotalElements()
        );
    }
}