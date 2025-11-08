package com.safesecurity.api.controller;

import com.safesecurity.api.model.Contacto;
import com.safesecurity.api.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactos")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Contacto>> obtenerContactos(@PathVariable Long usuarioId) {
        List<Contacto> contactos = contactoService.obtenerContactos(usuarioId);
        return ResponseEntity.ok(contactos);
    }
}
