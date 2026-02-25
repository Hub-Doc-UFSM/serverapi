package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.FluxoEtapas;
import com.hubdoc.serverapi.dto.fluxoEtapas.FluxoEtapasInputDTO;
import com.hubdoc.serverapi.dto.fluxoEtapas.FluxoEtapasResponseDTO;
import com.hubdoc.serverapi.mappers.FluxoEtapasMapper;
import com.hubdoc.serverapi.repositories.FluxoEtapasRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FluxoEtapasService {

    private final FluxoEtapasRepository repository;
    private final FluxoEtapasMapper mapper;

    @Transactional(readOnly = true)
    public Page<FluxoEtapasResponseDTO> findAll(Pageable pageable) {
        Page<FluxoEtapas> list = repository.findAll(pageable);
        return list.map(mapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public FluxoEtapasResponseDTO findById(Long id) {
        FluxoEtapas entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fluxo de etapas não encontrado com ID: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Transactional
    public FluxoEtapasResponseDTO insert(FluxoEtapasInputDTO dto) {
        FluxoEtapas entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    @Transactional
    public FluxoEtapasResponseDTO update(Long id, FluxoEtapasInputDTO dto) {
        FluxoEtapas entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Fluxo de etapas não encontrado com ID: " + id));

        mapper.copyToEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Fluxo de etapas não encontrado com ID: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir o fluxo de etapas pois ele possui registros dependentes.");
        }
    }
}
