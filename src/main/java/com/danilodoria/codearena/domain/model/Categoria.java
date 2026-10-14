package com.danilodoria.codearena.domain.model;

import java.util.Objects;

public class Categoria {

    private final Long id;
    private String nombre;

    public Categoria(String nombre) {
        this.id = null;
        this.nombre = normalizar(nombre);
    }

    public Categoria(Long id, String nombre) {
        this.id = Objects.requireNonNull(id, "El id es obligatorio al reconstruir una categoría");
        this.nombre = nombre;
    }

    private static String requireNoVacio(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la categoría es obligatorio");
        }
        return nombre;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }

    private static String normalizar(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la categoría es obligatorio");
        }
        return nombre.strip().replaceAll("\\s+", " ");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Categoria other)) return false;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}