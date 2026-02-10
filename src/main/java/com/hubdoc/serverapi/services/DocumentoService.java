package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Documento;
import com.hubdoc.serverapi.domain.entities.Maco;
import com.hubdoc.serverapi.dto.documento.DocumentoInputDTO;
import com.hubdoc.serverapi.dto.documento.DocumentoResponseDTO;
import com.hubdoc.serverapi.mappers.DocumentoMapper;
import com.hubdoc.serverapi.repositories.DocumentoRepository;
import com.hubdoc.serverapi.repositories.MacoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentoRepository repository;
    private final MacoRepository macoRepository;
    private final DocumentoMapper mapper;

    @Transactional(readOnly = true)
    public Page<DocumentoResponseDTO> findAll(Pageable pageable) {
        Page<Documento> list = repository.findAll(pageable);
        return list.map(mapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public DocumentoResponseDTO findById(Long id) {
        Documento documento = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Documento não encontrado com ID: " + id));
        return mapper.toResponseDTO(documento);
    }

    @Transactional
    public DocumentoResponseDTO insert(DocumentoInputDTO dto) {
        Documento documento = mapper.toEntity(dto);
        if (dto.getMacoId() != null) {
            Maco maco = macoRepository.findById(dto.getMacoId())
                    .orElseThrow(() -> new EntityNotFoundException("Maço não encontrado com ID: " + dto.getMacoId()));
            documento.setMaco(maco);
        }
        documento = repository.save(documento);

        // Gera o UUID automático somente após ter o ID gerado
        if (documento.getMaco() != null) {
            String uuid = generateUuid(documento);
            documento.setUuid(uuid);
            documento = repository.save(documento);
        }

        return mapper.toResponseDTO(documento);
    }

    private String generateUuid(Documento documento) {
        String siglaOrgao = documento.getMaco().getCaixa().getContrato().getOrgao().getSigla();
        Long idContrato = documento.getMaco().getCaixa().getContrato().getId();
        Long idCaixa = documento.getMaco().getCaixa().getId();
        Long idMaco = documento.getMaco().getId();
        Long idDocumento = documento.getId();

        return String.format("%s-%d-%d-%d-%d", siglaOrgao, idContrato, idCaixa, idMaco, idDocumento);
    }

    @Transactional
    public DocumentoResponseDTO update(Long id, DocumentoInputDTO dto) {
        Documento entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Documento não encontrado com ID: " + id));

        mapper.copyToEntity(dto, entity);

        if (dto.getMacoId() != null) {
            Maco maco = macoRepository.findById(dto.getMacoId())
                    .orElseThrow(() -> new EntityNotFoundException("Maço não encontrado com ID: " + dto.getMacoId()));
            entity.setMaco(maco);
        }

        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Documento não encontrado com ID: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir o documento pois ele possui registros dependentes.");
        }
    }

    @Transactional(readOnly = true)
    public List<DocumentoResponseDTO> findByMaco(Long macoId) {
        if (!macoRepository.existsById(macoId)) {
            throw new EntityNotFoundException("Maço não encontrado com ID: " + macoId);
        }
        List<Documento> list = repository.findByMacoId(macoId);
        return list.stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }
}