package com.safesecurity.api.controller;

import com.safesecurity.api.model.Dispositivo;
import com.safesecurity.api.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Dispositivo>> obtenerDispositivos(@PathVariable Long usuarioId) {
        List<Dispositivo> dispositivos = dispositivoService.obtenerDispositivos(usuarioId);
        return ResponseEntity.ok(dispositivos);
    }
}
