package com.hubdoc.serverapi.repositories;

import com.hubdoc.serverapi.domain.entities.Orgao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgaoRepository extends JpaRepository<Orgao, Long> {
}
