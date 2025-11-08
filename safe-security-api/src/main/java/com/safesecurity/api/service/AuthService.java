package com.safesecurity.api.service;

import com.safesecurity.api.model.Rol;
import com.safesecurity.api.model.Usuario;
import com.safesecurity.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolService rolService;

    public Optional<Usuario> login(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email, password);
    }

    public Usuario registrar(String email, String password, String rolNombre) {
        Rol rol = rolService.buscarPorNombre(rolNombre)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + rolNombre));

        Usuario usuario = new Usuario(null, email, password, rol);
        return usuarioRepository.save(usuario);
    }
}