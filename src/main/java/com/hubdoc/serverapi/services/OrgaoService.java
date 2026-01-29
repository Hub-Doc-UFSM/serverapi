package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Documento;
import com.hubdoc.serverapi.domain.entities.Orgao;
import com.hubdoc.serverapi.dto.DocumentoDTO;
import com.hubdoc.serverapi.dto.OrgaoDTO;
import com.hubdoc.serverapi.repositories.OrgaoRepository;
import com.hubdoc.serverapi.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class OrgaoService {

    @Autowired
    private OrgaoRepository repository;

    @Transactional(readOnly = true)
    public OrgaoDTO findById(Long id) {
        Orgao orgao = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id do Orgão não encontrado!")
        );
        return new OrgaoDTO(orgao);
    }
    @Transactional(readOnly = true)
    public Page<OrgaoDTO> findAll(Pageable pageable){
        Page<Orgao> result = repository.findAll(pageable);
        return result.map(OrgaoDTO::new);
    }
}
