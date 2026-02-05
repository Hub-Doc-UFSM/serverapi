package com.hubdoc.serverapi.mappers;

import com.hubdoc.serverapi.domain.entities.Caixa;
import com.hubdoc.serverapi.domain.entities.Contrato;
import com.hubdoc.serverapi.dto.caixa.CaixaInputDTO;
import com.hubdoc.serverapi.dto.caixa.CaixaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CaixaMapper {

    private final ContratoMapper contratoMapper;

    public Caixa toEntity(CaixaInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Caixa entity = new Caixa();
        copyToEntity(dto, entity);
        return entity;
    }

    public CaixaResponseDTO toResponseDTO(Caixa entity) {
        if (entity == null) {
            return null;
        }

        CaixaResponseDTO dto = new CaixaResponseDTO();
        dto.setId(entity.getId());
        dto.setCodigoEtiqueta(entity.getCodigoEtiqueta());

        if (entity.getContrato() != null) {
            dto.setContrato(contratoMapper.toResponseDTO(entity.getContrato()));
        }

        return dto;
    }

    public void copyToEntity(CaixaInputDTO dto, Caixa entity) {
        entity.setCodigoEtiqueta(dto.getCodigoEtiqueta());

        if (dto.getContratoId() != null) {
            Contrato contrato = new Contrato();
            contrato.setId(dto.getContratoId());
            entity.setContrato(contrato);
        } else {
            entity.setContrato(null);
        }
    }
}
