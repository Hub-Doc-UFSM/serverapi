package com.hubdoc.serverapi.repositories;

import com.hubdoc.serverapi.domain.entities.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
