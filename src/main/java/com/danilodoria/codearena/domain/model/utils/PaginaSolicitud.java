package com.danilodoria.codearena.domain.model.utils;

public record PaginaSolicitud(int pagina, int tamano) {
    public PaginaSolicitud {
        if (pagina < 0) throw new IllegalArgumentException("La página no puede ser negativa");
        if (tamano <= 0) throw new IllegalArgumentException("El tamaño debe ser mayor a cero");
    }
}
