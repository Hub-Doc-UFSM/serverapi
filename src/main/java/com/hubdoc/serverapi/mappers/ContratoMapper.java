package com.hubdoc.serverapi.mappers;


import com.hubdoc.serverapi.domain.entities.Contrato;
import com.hubdoc.serverapi.domain.entities.Orgao;
import com.hubdoc.serverapi.dto.OrgaoDTO;
import com.hubdoc.serverapi.dto.contrato.ContratoInputDTO;
import com.hubdoc.serverapi.dto.contrato.ContratoResponseDTO;
import com.hubdoc.serverapi.repositories.OrgaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContratoMapper {

    private final OrgaoRepository orgaoRepository;

    public Contrato toEntity(ContratoInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Contrato entity = new Contrato();
        entity.setCodigoContrato(dto.getCodigoContrato());
        entity.setDataInicio(dto.getDataInicio());
        entity.setAtivo(dto.getAtivo());

        if (dto.getOrgaoId() != null) {
            Orgao orgao = orgaoRepository.findById(dto.getOrgaoId())
                    .orElseThrow(() -> new RuntimeException("Orgao not found with ID: " + dto.getOrgaoId()));
            entity.setOrgao(orgao);
        }

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
            OrgaoDTO orgaoDTO = new OrgaoDTO();
            orgaoDTO.setId(entity.getOrgao().getId());
            orgaoDTO.setNome(entity.getOrgao().getNome());
            orgaoDTO.setSigla(entity.getOrgao().getSigla());

            dto.setOrgao(orgaoDTO);
        }

        return dto;
    }

    public void copyToEntity(ContratoInputDTO dto, Contrato entity) {
        entity.setCodigoContrato(dto.getCodigoContrato());
        entity.setDataInicio(dto.getDataInicio());
        entity.setAtivo(dto.getAtivo());

        if (dto.getOrgaoId() != null) {
            Orgao orgao = orgaoRepository.findById(dto.getOrgaoId())
                    .orElseThrow(() -> new RuntimeException("Orgao not found with ID: " + dto.getOrgaoId()));
            entity.setOrgao(orgao);
        }
    }
}
