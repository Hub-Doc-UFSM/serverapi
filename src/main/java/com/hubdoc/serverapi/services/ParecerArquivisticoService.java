package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Documento;
import com.hubdoc.serverapi.domain.entities.ParecerArquivistico;
import com.hubdoc.serverapi.domain.entities.Usuario;
import com.hubdoc.serverapi.dto.parecerArquivistico.ParecerArquivisticoInputDTO;
import com.hubdoc.serverapi.dto.parecerArquivistico.ParecerArquivisticoResponseDTO;
import com.hubdoc.serverapi.mappers.ParecerArquivisticoMapper;
import com.hubdoc.serverapi.repositories.DocumentoRepository;
import com.hubdoc.serverapi.repositories.ParecerArquivisticoRepository;
import com.hubdoc.serverapi.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParecerArquivisticoService {

    private final ParecerArquivisticoRepository repository;
    private final DocumentoRepository documentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ParecerArquivisticoMapper mapper;

    @Transactional(readOnly = true)
    public Page<ParecerArquivisticoResponseDTO> findAll(Pageable pageable) {
        Page<ParecerArquivistico> list = repository.findAll(pageable);
        return list.map(mapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public ParecerArquivisticoResponseDTO findById(Long id) {
        ParecerArquivistico entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parecer Arquivístico não encontrado com ID: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Transactional
    public ParecerArquivisticoResponseDTO insert(ParecerArquivisticoInputDTO dto) {
        ParecerArquivistico entity = mapper.toEntity(dto);

        if (dto.getDocumentoId() != null) {
            Documento documento = documentoRepository.findById(dto.getDocumentoId())
                    .orElseThrow(() -> new EntityNotFoundException("Documento não encontrado com ID: " + dto.getDocumentoId()));
            entity.setDocumento(documento);
        }

        if (dto.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                    .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));
            entity.setUsuario(usuario);
        }

        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    @Transactional
    public ParecerArquivisticoResponseDTO update(Long id, ParecerArquivisticoInputDTO dto) {
        ParecerArquivistico entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parecer Arquivístico não encontrado com ID: " + id));

        mapper.copyToEntity(dto, entity);

        if (dto.getDocumentoId() != null) {
            // Documento ID should match the ID in path variable since it's MapsId logic,
            // but we can ensure consistency or validate it.
            // If the user tries to change the document associated, it might be tricky because ID is PK.
            // Usually we just ensure the entity has the correct parent reference for persistence context.
            Documento documento = documentoRepository.findById(dto.getDocumentoId())
                    .orElseThrow(() -> new EntityNotFoundException("Documento não encontrado com ID: " + dto.getDocumentoId()));

            if (!documento.getId().equals(id)) {
                 throw new IllegalArgumentException("Não é permitido alterar o Documento associado a um Parecer Arquivístico existente.");
            }
            entity.setDocumento(documento);
        }

        if (dto.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                    .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));
            entity.setUsuario(usuario);
        }

        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Parecer Arquivístico não encontrado com ID: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir o parecer arquivístico pois ele possui registros dependentes.");
        }
    }
}
