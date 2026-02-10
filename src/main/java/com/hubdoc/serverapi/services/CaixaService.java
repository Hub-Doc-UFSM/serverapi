package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Caixa;
import com.hubdoc.serverapi.domain.entities.Contrato;
import com.hubdoc.serverapi.dto.caixa.CaixaInputDTO;
import com.hubdoc.serverapi.dto.caixa.CaixaResponseDTO;
import com.hubdoc.serverapi.mappers.CaixaMapper;
import com.hubdoc.serverapi.repositories.CaixaRepository;
import com.hubdoc.serverapi.repositories.ContratoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CaixaService {

    private final CaixaRepository repository;
    private final ContratoRepository contratoRepository;
    private final CaixaMapper mapper;

    @Transactional(readOnly = true)
    public Page<CaixaResponseDTO> findAll(Pageable pageable) {
        Page<Caixa> list = repository.findAll(pageable);
        return list.map(mapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public CaixaResponseDTO findById(Long id) {
        Caixa caixa = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Caixa não encontrada com ID: " + id));
        return mapper.toResponseDTO(caixa);
    }

    @Transactional
    public CaixaResponseDTO insert(CaixaInputDTO dto) {
        Caixa caixa = mapper.toEntity(dto);
        if (dto.getContratoId() != null) {
            Contrato contrato = contratoRepository.findById(dto.getContratoId())
                    .orElseThrow(() -> new EntityNotFoundException("Contrato não encontrado com ID: " + dto.getContratoId()));
            caixa.setContrato(contrato);
        }
        caixa = repository.save(caixa);
        return mapper.toResponseDTO(caixa);
    }

    @Transactional
    public CaixaResponseDTO update(Long id, CaixaInputDTO dto) {
        Caixa entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Caixa não encontrada com ID: " + id));

        mapper.copyToEntity(dto, entity);

        if (dto.getContratoId() != null) {
            Contrato contrato = contratoRepository.findById(dto.getContratoId())
                    .orElseThrow(() -> new EntityNotFoundException("Contrato não encontrado com ID: " + dto.getContratoId()));
            entity.setContrato(contrato);
        }

        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Caixa não encontrada com ID: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir a caixa pois ela possui registros dependentes (Maços).");
        }
    }

    @Transactional(readOnly = true)
    public List<CaixaResponseDTO> findByContrato(Long contratoId) {
        if (!contratoRepository.existsById(contratoId)) {
            throw new EntityNotFoundException("Contrato não encontrado com ID: " + contratoId);
        }
        List<Caixa> list = repository.findByContratoId(contratoId);
        return list.stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }
}
