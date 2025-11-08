package com.safesecurity.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Contacto() {}

    public Contacto(Long id, String nombre, String telefono, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.usuario = usuario;
    }

    // GETTERS & SETTERS
    // ...
}