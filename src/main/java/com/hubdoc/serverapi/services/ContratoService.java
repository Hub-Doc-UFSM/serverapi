package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Contrato;
import com.hubdoc.serverapi.domain.entities.Orgao;
import com.hubdoc.serverapi.dto.contrato.ContratoInputDTO;
import com.hubdoc.serverapi.dto.contrato.ContratoResponseDTO;
import com.hubdoc.serverapi.mappers.ContratoMapper;
import com.hubdoc.serverapi.repositories.ContratoRepository;
import com.hubdoc.serverapi.repositories.OrgaoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContratoService {

    private final ContratoRepository repository;
    private final OrgaoRepository orgaoRepository;
    private final ContratoMapper mapper;

    @Transactional(readOnly = true)
    public Page<ContratoResponseDTO> findAll(Pageable pageable) {
        Page<Contrato> list = repository.findAll(pageable);
        return list.map(mapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public ContratoResponseDTO findById(Long id) {
        Contrato contrato = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrato não encontrado com ID: " + id));
        return mapper.toResponseDTO(contrato);
    }

    @Transactional
    public ContratoResponseDTO insert(ContratoInputDTO dto) {
        Contrato contrato = mapper.toEntity(dto);
        if (dto.getOrgaoId() != null) {
            Orgao orgao = orgaoRepository.findById(dto.getOrgaoId())
                    .orElseThrow(() -> new EntityNotFoundException("Órgão não encontrado com ID: " + dto.getOrgaoId()));
            contrato.setOrgao(orgao);
        }
        contrato = repository.save(contrato);
        return mapper.toResponseDTO(contrato);
    }
    @Transactional
    public ContratoResponseDTO update(Long id, ContratoInputDTO dto) {
        Contrato entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrato não encontrado com ID: " + id));

        mapper.copyToEntity(dto, entity);

        if (dto.getOrgaoId() != null) {
            Orgao orgao = orgaoRepository.findById(dto.getOrgaoId())
                    .orElseThrow(() -> new EntityNotFoundException("Órgão não encontrado com ID: " + dto.getOrgaoId()));
            entity.setOrgao(orgao);
        }

        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Contrato não encontrado com ID: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir o contrato pois ele possui registros dependentes (Caixas ou Etapas).");
        }
    }

    @Transactional(readOnly = true)
    public Page<ContratoResponseDTO> findByOrgao(Long orgaoId, Pageable pageable) {
        if (!orgaoRepository.existsById(orgaoId)) {
            throw new EntityNotFoundException("Órgão não encontrado com ID: " + orgaoId);
        }
        Page<Contrato> list = repository.findByOrgaoId(orgaoId, pageable);
        return list.map(mapper::toResponseDTO);
    }
}
