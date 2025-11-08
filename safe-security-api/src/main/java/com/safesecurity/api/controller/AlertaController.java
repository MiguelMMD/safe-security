package com.safesecurity.api.controller;

import com.safesecurity.api.model.Alerta;
import com.safesecurity.api.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Alerta>> obtenerAlertas(@PathVariable Long usuarioId) {
        List<Alerta> alertas = alertaService.obtenerAlertas(usuarioId);
        return ResponseEntity.ok(alertas);
    }
}
