package com.hubdoc.serverapi.mappers;

import com.hubdoc.serverapi.domain.entities.Documento;
import com.hubdoc.serverapi.domain.entities.Maco;
import com.hubdoc.serverapi.dto.documento.DocumentoInputDTO;
import com.hubdoc.serverapi.dto.documento.DocumentoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DocumentoMapper {

    private final MacoMapper macoMapper;

    public Documento toEntity(DocumentoInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Documento entity = new Documento();
        copyToEntity(dto, entity);
        return entity;
    }

    public DocumentoResponseDTO toResponseDTO(Documento entity) {
        if (entity == null) {
            return null;
        }

        DocumentoResponseDTO dto = new DocumentoResponseDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setStatusGlobal(entity.getStatusGlobal());

        if (entity.getMaco() != null) {
            dto.setMaco(macoMapper.toResponseDTO(entity.getMaco()));
        }

        return dto;
    }

    public void copyToEntity(DocumentoInputDTO dto, Documento entity) {
        entity.setStatusGlobal(dto.getStatusGlobal());

        if (dto.getMacoId() != null) {
            Maco maco = new Maco();
            maco.setId(dto.getMacoId());
            entity.setMaco(maco);
        } else {
            entity.setMaco(null);
        }
    }
}
