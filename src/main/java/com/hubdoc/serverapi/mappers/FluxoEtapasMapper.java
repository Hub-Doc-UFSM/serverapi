package com.hubdoc.serverapi.mappers;

import com.hubdoc.serverapi.domain.entities.Contrato;
import com.hubdoc.serverapi.domain.entities.Etapa;
import com.hubdoc.serverapi.domain.entities.FluxoEtapas;
import com.hubdoc.serverapi.dto.fluxoEtapas.FluxoEtapasInputDTO;
import com.hubdoc.serverapi.dto.fluxoEtapas.FluxoEtapasResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FluxoEtapasMapper {

    private final ContratoMapper contratoMapper;
    private final EtapaMapper etapaMapper;

    public FluxoEtapas toEntity(FluxoEtapasInputDTO dto) {
        if (dto == null) {
            return null;
        }

        FluxoEtapas entity = new FluxoEtapas();

        copyToEntity(dto, entity);
        return entity;
    }

    public FluxoEtapasResponseDTO toResponseDTO(FluxoEtapas entity) {
        if (entity == null) {
            return null;
        }

        FluxoEtapasResponseDTO dto = new FluxoEtapasResponseDTO();
        dto.setId(entity.getId());
        dto.setOrdem(entity.getOrdem());

        if (entity.getContrato() != null) {
            dto.setContrato(contratoMapper.toResponseDTO(entity.getContrato()));
        }

        if (entity.getEtapa() != null) {
            dto.setEtapa(etapaMapper.toResponseDTO(entity.getEtapa()));
        }

        return dto;
    }

    public void copyToEntity(FluxoEtapasInputDTO dto, FluxoEtapas entity) {
        entity.setOrdem(dto.getOrdem());

        if (dto.getContratoId() != null) {
            Contrato contrato = new Contrato();
            contrato.setId(dto.getContratoId());
            entity.setContrato(contrato);
        } else {
            entity.setContrato(null);
        }

        if (dto.getEtapaId() != null) {
            Etapa etapa = new Etapa();
            etapa.setId(dto.getEtapaId());
            entity.setEtapa(etapa);
        } else {
            entity.setEtapa(null);
        }
    }
}

