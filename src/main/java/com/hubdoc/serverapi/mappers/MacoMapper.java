package com.hubdoc.serverapi.mappers;

import com.hubdoc.serverapi.domain.entities.Caixa;
import com.hubdoc.serverapi.domain.entities.Maco;
import com.hubdoc.serverapi.dto.maco.MacoInputDTO;
import com.hubdoc.serverapi.dto.maco.MacoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MacoMapper {

    private final CaixaMapper caixaMapper;

    public Maco toEntity(MacoInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Maco entity = new Maco();
        copyToEntity(dto, entity);
        return entity;
    }

    public MacoResponseDTO toResponseDTO(Maco entity) {
        if (entity == null) {
            return null;
        }

        MacoResponseDTO dto = new MacoResponseDTO();
        dto.setId(entity.getId());
        dto.setQuantidadeFolhas(entity.getQuantidadeFolhas());
        dto.setDescricao(entity.getDescricao());

        if (entity.getCaixa() != null) {
            dto.setCaixa(caixaMapper.toResponseDTO(entity.getCaixa()));
        }

        return dto;
    }

    public void copyToEntity(MacoInputDTO dto, Maco entity) {
        entity.setQuantidadeFolhas(dto.getQuantidadeFolhas());
        entity.setDescricao(dto.getDescricao());

        if (dto.getCaixaId() != null) {
            Caixa caixa = new Caixa();
            caixa.setId(dto.getCaixaId());
            entity.setCaixa(caixa);
        } else {
            entity.setCaixa(null);
        }
    }
}
