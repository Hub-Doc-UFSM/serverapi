package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.EtapasRealizadas;
import com.hubdoc.serverapi.dto.etapasRealizadas.EtapasRealizadasInputDTO;
import com.hubdoc.serverapi.dto.etapasRealizadas.EtapasRealizadasResponseDTO;
import com.hubdoc.serverapi.mappers.EtapasRealizadasMapper;
import com.hubdoc.serverapi.repositories.EtapasRealizadasRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EtapasRealizadasService {

    private final EtapasRealizadasRepository repository;
    private final EtapasRealizadasMapper mapper;

    @Transactional(readOnly = true)
    public Page<EtapasRealizadasResponseDTO> findAll(Pageable pageable) {
        Page<EtapasRealizadas> list = repository.findAll(pageable);
        return list.map(mapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public EtapasRealizadasResponseDTO findById(Long id) {
        EtapasRealizadas entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etapa realizada não encontrada com ID: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Transactional
    public EtapasRealizadasResponseDTO insert(EtapasRealizadasInputDTO dto) {
        EtapasRealizadas entity = mapper.toEntity(dto);
        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    @Transactional
    public EtapasRealizadasResponseDTO update(Long id, EtapasRealizadasInputDTO dto) {
        EtapasRealizadas entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etapa realizada não encontrada com ID: " + id));

        mapper.copyToEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Etapa realizada não encontrada com ID: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir a etapa realizada pois ela possui registros dependentes.");
        }
    }
}
