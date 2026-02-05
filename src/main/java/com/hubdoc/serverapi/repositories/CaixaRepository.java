package com.hubdoc.serverapi.repositories;

import com.hubdoc.serverapi.domain.entities.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaixaRepository extends JpaRepository<Caixa, Long> {
}
