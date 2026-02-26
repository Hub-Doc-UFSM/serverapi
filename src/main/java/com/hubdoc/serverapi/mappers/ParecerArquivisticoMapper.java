package com.hubdoc.serverapi.mappers;

import com.hubdoc.serverapi.domain.entities.Documento;
import com.hubdoc.serverapi.domain.entities.ParecerArquivistico;
import com.hubdoc.serverapi.domain.entities.Usuario;
import com.hubdoc.serverapi.dto.parecerArquivistico.ParecerArquivisticoInputDTO;
import com.hubdoc.serverapi.dto.parecerArquivistico.ParecerArquivisticoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParecerArquivisticoMapper {

    private final DocumentoMapper documentoMapper;
    private final UsuarioMapper usuarioMapper;

    public ParecerArquivistico toEntity(ParecerArquivisticoInputDTO dto) {
        if (dto == null) {
            return null;
        }

        ParecerArquivistico entity = new ParecerArquivistico();
        copyToEntity(dto, entity);
        return entity;
    }

    public ParecerArquivisticoResponseDTO toResponseDTO(ParecerArquivistico entity) {
        if (entity == null) {
            return null;
        }

        ParecerArquivisticoResponseDTO dto = new ParecerArquivisticoResponseDTO();
        dto.setId(entity.getId());
        dto.setDataParecer(entity.getDataParecer());
        dto.setRasgado(entity.getRasgado());
        dto.setSemPerdaInfo(entity.getSemPerdaInfo());
        dto.setManchas(entity.getManchas());
        dto.setComPerdaInfo(entity.getComPerdaInfo());
        dto.setDanoFerrugem(entity.getDanoFerrugem());
        dto.setPaginasFaltando(entity.getPaginasFaltando());
        dto.setAcidificado(entity.getAcidificado());
        dto.setPaginasColadas(entity.getPaginasColadas());
        dto.setPorosoQuebradico(entity.getPorosoQuebradico());
        dto.setEstadoConservacao(entity.getEstadoConservacao());
        dto.setIndicacaoReparacao(entity.getIndicacaoReparacao());
        dto.setObservacoesGerais(entity.getObservacoesGerais());

        if (entity.getDocumento() != null) {
            dto.setDocumento(documentoMapper.toResponseDTO(entity.getDocumento()));
        }

        if (entity.getUsuario() != null) {
            dto.setUsuario(usuarioMapper.toResponseDTO(entity.getUsuario()));
        }

        return dto;
    }

    public void copyToEntity(ParecerArquivisticoInputDTO dto, ParecerArquivistico entity) {
        entity.setDataParecer(dto.getDataParecer());
        entity.setRasgado(dto.getRasgado());
        entity.setSemPerdaInfo(dto.getSemPerdaInfo());
        entity.setManchas(dto.getManchas());
        entity.setComPerdaInfo(dto.getComPerdaInfo());
        entity.setDanoFerrugem(dto.getDanoFerrugem());
        entity.setPaginasFaltando(dto.getPaginasFaltando());
        entity.setAcidificado(dto.getAcidificado());
        entity.setPaginasColadas(dto.getPaginasColadas());
        entity.setPorosoQuebradico(dto.getPorosoQuebradico());
        entity.setEstadoConservacao(dto.getEstadoConservacao());
        entity.setIndicacaoReparacao(dto.getIndicacaoReparacao());
        entity.setObservacoesGerais(dto.getObservacoesGerais());

        if (dto.getDocumentoId() != null) {
            Documento documento = new Documento();
            documento.setId(dto.getDocumentoId());
            entity.setDocumento(documento);
        } else {
            entity.setDocumento(null);
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
