package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.domain.entities.Caixa;
import com.hubdoc.serverapi.domain.entities.Maco;
import com.hubdoc.serverapi.dto.maco.MacoInputDTO;
import com.hubdoc.serverapi.dto.maco.MacoResponseDTO;
import com.hubdoc.serverapi.mappers.MacoMapper;
import com.hubdoc.serverapi.repositories.CaixaRepository;
import com.hubdoc.serverapi.repositories.MacoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MacoService {

    private final MacoRepository repository;
    private final CaixaRepository caixaRepository;
    private final MacoMapper mapper;

    @Transactional(readOnly = true)
    public Page<MacoResponseDTO> findAll(Pageable pageable) {
        Page<Maco> list = repository.findAll(pageable);
        return list.map(mapper::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public MacoResponseDTO findById(Long id) {
        Maco maco = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maço não encontrado com ID: " + id));
        return mapper.toResponseDTO(maco);
    }

    @Transactional
    public MacoResponseDTO insert(MacoInputDTO dto) {
        Maco maco = mapper.toEntity(dto);
        if (dto.getCaixaId() != null) {
            Caixa caixa = caixaRepository.findById(dto.getCaixaId())
                    .orElseThrow(() -> new EntityNotFoundException("Caixa não encontrada com ID: " + dto.getCaixaId()));
            maco.setCaixa(caixa);
        }
        maco = repository.save(maco);
        return mapper.toResponseDTO(maco);
    }

    @Transactional
    public MacoResponseDTO update(Long id, MacoInputDTO dto) {
        Maco entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maço não encontrado com ID: " + id));

        mapper.copyToEntity(dto, entity);

        if (dto.getCaixaId() != null) {
            Caixa caixa = caixaRepository.findById(dto.getCaixaId())
                    .orElseThrow(() -> new EntityNotFoundException("Caixa não encontrada com ID: " + dto.getCaixaId()));
            entity.setCaixa(caixa);
        }

        entity = repository.save(entity);
        return mapper.toResponseDTO(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Maço não encontrado com ID: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir o maço pois ele possui registros dependentes.");
        }
    }
}
