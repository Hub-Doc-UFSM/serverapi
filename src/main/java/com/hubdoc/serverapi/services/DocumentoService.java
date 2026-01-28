package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Documento;
import com.hubdoc.serverapi.dto.DocumentoDTO;
import com.hubdoc.serverapi.repositories.DocumentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository repository;

    @Transactional(readOnly = true)
    public Page<DocumentoDTO> findAll(Pageable pageable){
        Page<Documento> result = repository.findAll(pageable);
        return result.map(DocumentoDTO::new);
    }
}