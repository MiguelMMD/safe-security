package com.safesecurity.api.service;

import com.safesecurity.api.model.Rol;
import com.safesecurity.api.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public Rol crearRol(String nombre) {
        return rolRepository.save(new Rol(null, nombre));
    }

    public Optional<Rol> buscarPorNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }
}
