package com.safesecurity.api.repository;

import com.safesecurity.api.model.Contacto;
import com.safesecurity.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {

    List<Contacto> findByUsuario(Usuario usuario);
}
