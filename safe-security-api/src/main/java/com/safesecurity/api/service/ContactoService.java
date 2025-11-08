package com.safesecurity.api.service;

import com.safesecurity.api.model.Contacto;
import com.safesecurity.api.model.Usuario;
import com.safesecurity.api.repository.ContactoRepository;
import com.safesecurity.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Contacto> obtenerContactos(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return contactoRepository.findByUsuario(usuario);
    }

    public Contacto agregarContacto(Long usuarioId, String nombre, String telefono) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Contacto contacto = new Contacto(null, nombre, telefono, usuario);
        return contactoRepository.save(contacto);
    }
}
