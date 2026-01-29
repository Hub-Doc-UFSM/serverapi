package com.hubdoc.serverapi.mappers;

import com.hubdoc.serverapi.domain.entities.Orgao;
import com.hubdoc.serverapi.dto.OrgaoDTO;
import org.springframework.stereotype.Component;

@Component
public class OrgaoMapper {

    public OrgaoDTO toDTO(Orgao entity) {
        if (entity == null) {
            return null;
        }

        OrgaoDTO dto = new OrgaoDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setSigla(entity.getSigla());

        return dto;
    }
    public Orgao toEntity(OrgaoDTO dto) {
        if (dto == null) {
            return null;
        }

        Orgao entity = new Orgao();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setSigla(dto.getSigla());

        return entity;
    }
    public void updateEntity(OrgaoDTO dto, Orgao entity) {
        if (dto == null || entity == null) {
            return;
        }
        entity.setNome(dto.getNome());
        entity.setSigla(dto.getSigla());
    }
}
