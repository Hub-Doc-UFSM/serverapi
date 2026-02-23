package com.hubdoc.serverapi.repositories;

import com.hubdoc.serverapi.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
