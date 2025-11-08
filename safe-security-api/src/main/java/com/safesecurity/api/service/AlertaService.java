package com.safesecurity.api.service;

import com.safesecurity.api.model.Alerta;
import com.safesecurity.api.model.Usuario;
import com.safesecurity.api.repository.AlertaRepository;
import com.safesecurity.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Envía una alerta manualmente (si la usas desde otro lado)
     */
    public Alerta enviarAlerta(Long usuarioId, String nivel) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Alerta alerta = new Alerta(null, nivel, usuario);
        return alertaRepository.save(alerta);
    }

    /**
     * Listar alertas por usuario (tu método original)
     */
    public List<Alerta> listarAlertas(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return alertaRepository.findByUsuario(usuario);
    }

    /**
     * ✅ Método que TU CONTROLADOR necesita:
     *    GET /alertas/{usuarioId}
     *    Este nombre es el que tu controlador está llamando.
     */
    public List<Alerta> obtenerAlertas(Long usuarioId) {
        return listarAlertas(usuarioId);
    }
}
