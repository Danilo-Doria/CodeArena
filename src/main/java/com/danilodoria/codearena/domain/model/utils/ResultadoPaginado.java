package com.danilodoria.codearena.domain.model.utils;

import java.util.List;

public record ResultadoPaginado<T>(List<T> contenido, int paginaActual, int totalPaginas, long totalElementos) {
}
