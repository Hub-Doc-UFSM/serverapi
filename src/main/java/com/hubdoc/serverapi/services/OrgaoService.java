package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Documento;
import com.hubdoc.serverapi.domain.entities.Orgao;
import com.hubdoc.serverapi.dto.DocumentoDTO;
import com.hubdoc.serverapi.dto.OrgaoDTO;
import com.hubdoc.serverapi.mappers.DocumentoMapper;
import com.hubdoc.serverapi.mappers.OrgaoMapper;
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

    @Autowired
    private OrgaoMapper mapper;

    @Transactional(readOnly = true)
    public OrgaoDTO findById(Long id) {
        Orgao orgao = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id do Orgão não encontrado!")
        );
        return mapper.toDTO(orgao);
    }
    @Transactional(readOnly = true)
    public Page<OrgaoDTO> findAll(Pageable pageable){
        Page<Orgao> result = repository.findAll(pageable);
        return result.map(mapper::toDTO);
    }
    @Transactional
    public OrgaoDTO insert(OrgaoDTO dto) {
        Orgao orgao = mapper.toEntity(dto);
        orgao = repository.save(orgao);
        return mapper.toDTO(orgao);
    }

    @Transactional
    public OrgaoDTO update(Long id, OrgaoDTO dto) {
        Orgao orgao = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id do Orgão não encontrado!")
        );
        mapper.updateEntity(dto, orgao);
        orgao = repository.save(orgao);
        return mapper.toDTO(orgao);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id do Orgão não encontrado!");
        }
        repository.deleteById(id);
    }
}
