package com.hubdoc.serverapi.mappers;

import com.hubdoc.serverapi.domain.entities.Documento;
import com.hubdoc.serverapi.dto.DocumentoDTO;
import org.springframework.stereotype.Component;

@Component
public class DocumentoMapper {

    public DocumentoDTO toDTO(Documento entity) {
        if (entity == null) {
            return null;
        }

        DocumentoDTO dto = new DocumentoDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setStatusGlobal(entity.getStatusGlobal());

        return dto;
    }

    public Documento toEntity(DocumentoDTO dto) {
        if (dto == null) {
            return null;
        }

        Documento entity = new Documento();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setStatusGlobal(dto.getStatusGlobal());

        return entity;
    }
}
