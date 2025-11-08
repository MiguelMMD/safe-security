package com.safesecurity.api.service;

import com.safesecurity.api.model.Dispositivo;
import com.safesecurity.api.model.Usuario;
import com.safesecurity.api.repository.DispositivoRepository;
import com.safesecurity.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Dispositivo vincularDispositivo(Long usuarioId, String token) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Dispositivo dispositivo = new Dispositivo(null, token, usuario);
        return dispositivoRepository.save(dispositivo);
    }

    public List<Dispositivo> obtenerDispositivos(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return dispositivoRepository.findByUsuario(usuario);
    }
}
