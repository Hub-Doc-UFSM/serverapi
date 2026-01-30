package com.hubdoc.serverapi.repositories;

import com.hubdoc.serverapi.domain.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
