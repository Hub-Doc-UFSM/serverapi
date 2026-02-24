package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Etapa;
import com.hubdoc.serverapi.dto.etapa.EtapaInputDTO;
import com.hubdoc.serverapi.dto.etapa.EtapaResponseDTO;
import com.hubdoc.serverapi.mappers.EtapaMapper;
import com.hubdoc.serverapi.repositories.EtapaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EtapaService {

    private final EtapaRepository repository;
    private final EtapaMapper mapper;

    @Transactional(readOnly = true)
    public Page<EtapaResponseDTO> findAll(Pageable pageable) {
        Page<Etapa> list = repository.findAll(pageable);
        return list.map(mapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public EtapaResponseDTO findById(Long id) {
        Etapa etapa = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etapa não encontrada com ID: " + id));
        return mapper.toResponseDTO(etapa);
    }

    @Transactional
    public EtapaResponseDTO insert(EtapaInputDTO dto) {
        Etapa etapa = mapper.toEntity(dto);
        etapa = repository.save(etapa);
        return mapper.toResponseDTO(etapa);
    }

    @Transactional
    public EtapaResponseDTO update(Long id, EtapaInputDTO dto) {
        Etapa entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Etapa não encontrada com ID: " + id));

        mapper.copyToEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Etapa não encontrada com ID: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir a etapa pois ela possui registros dependentes.");
        }
    }
}
