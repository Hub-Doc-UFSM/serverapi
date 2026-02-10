package com.hubdoc.serverapi.repositories;

import com.hubdoc.serverapi.domain.entities.Maco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MacoRepository extends JpaRepository<Maco, Long>{
    List<Maco> findByCaixaId(Long caixaId);
}
