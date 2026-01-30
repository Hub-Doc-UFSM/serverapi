package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Contrato;
import com.hubdoc.serverapi.dto.OrgaoDTO;
import com.hubdoc.serverapi.dto.contrato.ContratoInputDTO;
import com.hubdoc.serverapi.dto.contrato.ContratoResponseDTO;
import com.hubdoc.serverapi.mappers.ContratoMapper;
import com.hubdoc.serverapi.repositories.ContratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContratoService {

    private final ContratoRepository repository;
    private final ContratoMapper mapper;

    @Transactional
    public ContratoResponseDTO insert(ContratoInputDTO dto) {
        Contrato contrato = mapper.toEntity(dto);
        contrato = repository.save(contrato);
        return mapper.toResponseDTO(contrato);
    }
}
