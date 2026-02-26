package com.hubdoc.serverapi.mappers;

import com.hubdoc.serverapi.domain.entities.Documento;
import com.hubdoc.serverapi.domain.entities.Etapa;
import com.hubdoc.serverapi.domain.entities.EtapasRealizadas;
import com.hubdoc.serverapi.domain.entities.Usuario;
import com.hubdoc.serverapi.dto.etapasRealizadas.EtapasRealizadasInputDTO;
import com.hubdoc.serverapi.dto.etapasRealizadas.EtapasRealizadasResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EtapasRealizadasMapper {

    private final DocumentoMapper documentoMapper;
    private final EtapaMapper etapaMapper;
    private final UsuarioMapper usuarioMapper;

    public EtapasRealizadas toEntity(EtapasRealizadasInputDTO dto) {
        if (dto == null) {
            return null;
        }

        EtapasRealizadas entity = new EtapasRealizadas();
        copyToEntity(dto, entity);
        return entity;
    }

    public EtapasRealizadasResponseDTO toResponseDTO(EtapasRealizadas entity) {
        if (entity == null) {
            return null;
        }

        EtapasRealizadasResponseDTO dto = new EtapasRealizadasResponseDTO();
        dto.setId(entity.getId());
        dto.setDataInicio(entity.getDataInicio());
        dto.setDataFim(entity.getDataFim());
        dto.setObservacaoTecnica(entity.getObservacaoTecnica());
        dto.setStatus(entity.getStatus());

        if (entity.getDocumento() != null) {
            dto.setDocumento(documentoMapper.toResponseDTO(entity.getDocumento()));
        }

        if (entity.getEtapa() != null) {
            dto.setEtapa(etapaMapper.toResponseDTO(entity.getEtapa()));
        }

        if (entity.getUsuario() != null) {
            dto.setUsuario(usuarioMapper.toResponseDTO(entity.getUsuario()));
        }

        return dto;
    }

    public void copyToEntity(EtapasRealizadasInputDTO dto, EtapasRealizadas entity) {
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataFim(dto.getDataFim());
        entity.setObservacaoTecnica(dto.getObservacaoTecnica());
        entity.setStatus(dto.getStatus());

        if (dto.getDocumentoId() != null) {
            Documento documento = new Documento();
            documento.setId(dto.getDocumentoId());
            entity.setDocumento(documento);
        } else {
            entity.setDocumento(null);
        }

        if (dto.getEtapaId() != null) {
            Etapa etapa = new Etapa();
            etapa.setId(dto.getEtapaId());
            entity.setEtapa(etapa);
        } else {
            entity.setEtapa(null);
        }

        if (dto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuarioId());
            entity.setUsuario(usuario);
        } else {
            entity.setUsuario(null);
        }
    }
}
