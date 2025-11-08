package com.safesecurity.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nivel;

    private LocalDateTime fecha = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Alerta() {}

    public Alerta(Long id, String nivel, Usuario usuario) {
        this.id = id;
        this.nivel = nivel;
        this.usuario = usuario;
    }

    // GETTERS & SETTERS
}
