package com.safesecurity.api.repository;

import com.safesecurity.api.model.Alerta;
import com.safesecurity.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    List<Alerta> findByUsuario(Usuario usuario);
}
