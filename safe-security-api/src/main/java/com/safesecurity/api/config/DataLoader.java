package com.safesecurity.api.config;

import com.safesecurity.api.model.Rol;
import com.safesecurity.api.model.Usuario;
import com.safesecurity.api.repository.UsuarioRepository;
import com.safesecurity.api.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) {

        // Crear roles
        Rol comandante = rolService.crearRol("comandante");
        Rol policia = rolService.crearRol("policia");
        Rol usuario = rolService.crearRol("usuario");
        Rol familiar = rolService.crearRol("familiar");

        // Usuarios iniciales
        usuarioRepository.save(new Usuario(null, "comandante", "comandante", comandante));
        usuarioRepository.save(new Usuario(null, "policia", "policia", policia));
        usuarioRepository.save(new Usuario(null, "usuario", "usuario", usuario));
        usuarioRepository.save(new Usuario(null, "familiar", "familiar", familiar));

        System.out.println("✅ Usuarios y roles creados automáticamente");
    }
}
