package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.documento.DocumentoInputDTO;
import com.hubdoc.serverapi.dto.documento.DocumentoResponseDTO;
import com.hubdoc.serverapi.services.DocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService service;

    @GetMapping
    public ResponseEntity<Page<DocumentoResponseDTO>> findAll(Pageable pageable) {
        Page<DocumentoResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DocumentoResponseDTO> findById(@PathVariable Long id) {
        DocumentoResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DocumentoResponseDTO> insert(@RequestBody DocumentoInputDTO dto) {
        DocumentoResponseDTO response = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DocumentoResponseDTO> update(@PathVariable Long id, @RequestBody DocumentoInputDTO dto) {
        DocumentoResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
