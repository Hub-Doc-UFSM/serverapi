package com.hubdoc.serverapi.mappers;

import com.hubdoc.serverapi.domain.entities.Usuario;
import com.hubdoc.serverapi.dto.usuario.UsuarioInputDTO;
import com.hubdoc.serverapi.dto.usuario.UsuarioResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {

    public Usuario toEntity(UsuarioInputDTO dto) {
        if (dto == null) {
            return null;
        }

        Usuario entity = new Usuario();
        copyToEntity(dto, entity);
        return entity;
    }

    public UsuarioResponseDTO toResponseDTO(Usuario entity) {
        if (entity == null) {
            return null;
        }

        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCodigoDeBarras(entity.getCodigoDeBarras());
        dto.setAtivo(entity.getAtivo());
        dto.setTipoUsuario(entity.getTipoUsuario());

        return dto;
    }

    public void copyToEntity(UsuarioInputDTO dto, Usuario entity) {
        entity.setNome(dto.getNome());
        entity.setCodigoDeBarras(dto.getCodigoDeBarras());
        entity.setSenha(dto.getSenha());
        entity.setAtivo(dto.getAtivo());
        entity.setTipoUsuario(dto.getTipoUsuario());
    }
}
