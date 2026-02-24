package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Usuario;
import com.hubdoc.serverapi.dto.usuario.UsuarioInputDTO;
import com.hubdoc.serverapi.dto.usuario.UsuarioResponseDTO;
import com.hubdoc.serverapi.mappers.UsuarioMapper;
import com.hubdoc.serverapi.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    @Transactional(readOnly = true)
    public Page<UsuarioResponseDTO> findAll(Pageable pageable) {
        Page<Usuario> list = repository.findAll(pageable);
        return list.map(mapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        return mapper.toResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO insert(UsuarioInputDTO dto) {
        Usuario usuario = mapper.toEntity(dto);
        usuario = repository.save(usuario);
        return mapper.toResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO update(Long id, UsuarioInputDTO dto) {
        Usuario entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        mapper.copyToEntity(dto, entity);
        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir o usuário pois ele possui registros dependentes.");
        }
    }
}
