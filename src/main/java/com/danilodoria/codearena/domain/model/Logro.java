package com.danilodoria.codearena.domain.model;

import java.util.Objects;

public class Logro {

    private final Long id;
    private String nombre;
    private String descripcion;

    public Logro(String nombre, String descripcion) {
        this.id = null;
        this.nombre = requireNoVacio(nombre);
        this.descripcion = descripcion;
    }

    public Logro(Long id, String nombre, String descripcion) {
        this.id = Objects.requireNonNull(id, "El id es obligatorio al reconstruir un logro");
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    private static String requireNoVacio(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del logro es obligatorio");
        }
        return nombre;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Logro other)) return false;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}