package com.hubdoc.serverapi.repositories;

import com.hubdoc.serverapi.domain.entities.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgaoRepository extends JpaRepository<Documento, Long> {
}
