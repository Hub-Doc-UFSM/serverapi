package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Orgao;
import com.hubdoc.serverapi.dto.orgao.OrgaoInputDTO;
import com.hubdoc.serverapi.dto.orgao.OrgaoResponseDTO;
import com.hubdoc.serverapi.mappers.OrgaoMapper;
import com.hubdoc.serverapi.repositories.OrgaoRepository;
import com.hubdoc.serverapi.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class OrgaoService {

    private final OrgaoRepository repository;
    private final OrgaoMapper mapper;

    @Transactional(readOnly = true)
    public OrgaoResponseDTO findById(Long id) {
        Orgao orgao = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id do Orgão não encontrado!")
        );
        return mapper.toResponseDTO(orgao);
    }
    @Transactional(readOnly = true)
    public Page<OrgaoResponseDTO> findAll(Pageable pageable){
        Page<Orgao> result = repository.findAll(pageable);
        return result.map(mapper::toResponseDTO);
    }
    @Transactional
    public OrgaoResponseDTO insert(OrgaoInputDTO dto) {
        Orgao orgao = mapper.toEntity(dto);
        orgao = repository.save(orgao);
        return mapper.toResponseDTO(orgao);
    }

    @Transactional
    public OrgaoResponseDTO update(Long id, OrgaoInputDTO dto) {
        Orgao orgao = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id do Orgão não encontrado!")
        );
        mapper.updateEntity(dto, orgao);
        orgao = repository.save(orgao);
        return mapper.toResponseDTO(orgao);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id do Orgão não encontrado!");
        }
        repository.deleteById(id);
    }
}
