package com.hubdoc.serverapi.mappers;

import com.hubdoc.serverapi.domain.entities.Orgao;
import com.hubdoc.serverapi.dto.orgao.OrgaoInputDTO;
import com.hubdoc.serverapi.dto.orgao.OrgaoResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class OrgaoMapper {

    public OrgaoResponseDTO toResponseDTO(Orgao entity) {
        if (entity == null) {
            return null;
        }

        OrgaoResponseDTO dto = new OrgaoResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setSigla(entity.getSigla());

        return dto;
    }
    public Orgao toEntity(OrgaoInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Orgao entity = new Orgao();
        entity.setNome(dto.getNome());
        entity.setSigla(dto.getSigla());

        return entity;
    }
    public void updateEntity(OrgaoInputDTO dto, Orgao entity) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setNome(dto.getNome());
        entity.setSigla(dto.getSigla());
    }
}
