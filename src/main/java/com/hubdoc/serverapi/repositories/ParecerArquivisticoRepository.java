package com.hubdoc.serverapi.repositories;

import com.hubdoc.serverapi.domain.entities.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParecerArquivisticoRepository extends JpaRepository<Etapa, Long> {
}
