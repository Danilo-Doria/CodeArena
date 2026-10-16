package com.danilodoria.codearena.infrastructure.adapter.out.persistence.entity;

import com.danilodoria.codearena.domain.model.EstadoUsuario;
import com.danilodoria.codearena.domain.model.Nivel;
import com.danilodoria.codearena.domain.model.Rol;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "usuarios",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_usuarios_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_usuarios_username", columnNames = "username")
        }
)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Rol rol;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Nivel nivel;

    @Column(name = "experiencia_acumulada", nullable = false)
    private int experienciaAcumulada;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoUsuario estado;
}