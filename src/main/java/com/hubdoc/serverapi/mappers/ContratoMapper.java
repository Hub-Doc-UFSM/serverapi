package com.hubdoc.serverapi.mappers;


import com.hubdoc.serverapi.domain.entities.Contrato;
import com.hubdoc.serverapi.domain.entities.Orgao;
import com.hubdoc.serverapi.dto.orgao.OrgaoResponseDTO;
import com.hubdoc.serverapi.dto.contrato.ContratoInputDTO;
import com.hubdoc.serverapi.dto.contrato.ContratoResponseDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContratoMapper {

    public Contrato toEntity(ContratoInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Contrato entity = new Contrato();
        copyToEntity(dto, entity);
        return entity;
    }

    public ContratoResponseDTO toResponseDTO(Contrato entity) {
        if (entity == null) {
            return null;
        }

        ContratoResponseDTO dto = new ContratoResponseDTO();
        dto.setId(entity.getId());
        dto.setCodigoContrato(entity.getCodigoContrato());
        dto.setDataInicio(entity.getDataInicio());
        dto.setAtivo(entity.getAtivo());

        if (entity.getOrgao() != null) {
            OrgaoResponseDTO orgaoResponseDTO = new OrgaoResponseDTO();
            orgaoResponseDTO.setId(entity.getOrgao().getId());
            orgaoResponseDTO.setNome(entity.getOrgao().getNome());
            orgaoResponseDTO.setSigla(entity.getOrgao().getSigla());

            dto.setOrgao(orgaoResponseDTO);
        }

        return dto;
    }

    public void copyToEntity(ContratoInputDTO dto, Contrato entity) {
        entity.setCodigoContrato(dto.getCodigoContrato());
        entity.setDataInicio(dto.getDataInicio());
        entity.setAtivo(dto.getAtivo());
        if (dto.getOrgaoId() != null) {
            Orgao orgaoDTO = new Orgao();
            orgaoDTO.setId(dto.getOrgaoId());
            entity.setOrgao(orgaoDTO);
        } else {
            entity.setOrgao(null);
        }
    }
}
