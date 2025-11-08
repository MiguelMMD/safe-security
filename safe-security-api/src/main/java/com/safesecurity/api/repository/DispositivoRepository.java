package com.safesecurity.api.repository;

import com.safesecurity.api.model.Dispositivo;
import com.safesecurity.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

    List<Dispositivo> findByUsuario(Usuario usuario);
}
