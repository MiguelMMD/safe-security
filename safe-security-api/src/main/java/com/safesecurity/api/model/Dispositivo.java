package com.safesecurity.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dispositivos")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Dispositivo() {}

    public Dispositivo(Long id, String token, Usuario usuario) {
        this.id = id;
        this.token = token;
        this.usuario = usuario;
    }

    // GETTERS & SETTERS
}