package com.hubdoc.serverapi.repositories;

import com.hubdoc.serverapi.domain.entities.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    List<Documento> findByMacoId(Long macoId);
}
