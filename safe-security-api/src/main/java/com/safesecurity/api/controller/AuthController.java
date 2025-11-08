package com.safesecurity.api.controller;

import com.safesecurity.api.dto.LoginRequest;
import com.safesecurity.api.dto.RegisterRequest;
import com.safesecurity.api.model.Usuario;
import com.safesecurity.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")   // ✅ RUTA PRINCIPAL DEL MÓDULO
public class AuthController {

    @Autowired
    private AuthService authService;

    // ✅ RUTA: POST http://localhost:8080/auth/login
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        Optional<Usuario> usuarioOpt = authService.login(request.email, request.password);

        if (usuarioOpt.isPresent()) {
            return ResponseEntity.ok(usuarioOpt.get());
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }

    // ✅ RUTA: POST http://localhost:8080/auth/register
    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody RegisterRequest req) {
        Usuario u = authService.registrar(req.email, req.password, req.rol);
        return ResponseEntity.ok(u);
    }
}
