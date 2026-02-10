package com.hubdoc.serverapi.repositories;

import com.hubdoc.serverapi.domain.entities.Contrato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    Page<Contrato> findByOrgaoId(Long orgaoId, Pageable pageable);
}
