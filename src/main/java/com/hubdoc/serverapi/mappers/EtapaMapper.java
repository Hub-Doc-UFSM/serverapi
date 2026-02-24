package com.hubdoc.serverapi.mappers;

import com.hubdoc.serverapi.domain.entities.Etapa;
import com.hubdoc.serverapi.dto.etapa.EtapaInputDTO;
import com.hubdoc.serverapi.dto.etapa.EtapaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EtapaMapper {

    public Etapa toEntity(EtapaInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Etapa entity = new Etapa();
        copyToEntity(dto, entity);
        return entity;
    }

    public EtapaResponseDTO toResponseDTO(Etapa entity) {
        if (entity == null) {
            return null;
        }

        EtapaResponseDTO dto = new EtapaResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());

        return dto;
    }

    public void copyToEntity(EtapaInputDTO dto, Etapa entity) {
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
    }
}
