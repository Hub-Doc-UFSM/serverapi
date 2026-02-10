package com.hubdoc.serverapi.repositories;

import com.hubdoc.serverapi.domain.entities.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaixaRepository extends JpaRepository<Caixa, Long> {
    List<Caixa> findByContratoId(Long contratoId);
}
