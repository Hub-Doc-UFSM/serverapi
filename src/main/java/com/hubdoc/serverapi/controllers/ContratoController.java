package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.contrato.ContratoInputDTO;
import com.hubdoc.serverapi.dto.contrato.ContratoResponseDTO;
import com.hubdoc.serverapi.services.ContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/contratos")
@RequiredArgsConstructor
public class ContratoController {

    private final ContratoService service;

    @GetMapping
    public ResponseEntity<Page<ContratoResponseDTO>> findAll(Pageable pageable) {
        Page<ContratoResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContratoResponseDTO> findById(@PathVariable Long id) {
        ContratoResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ContratoResponseDTO> insert(@RequestBody ContratoInputDTO dto) {
        ContratoResponseDTO response = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContratoResponseDTO> update(@PathVariable Long id, @RequestBody ContratoInputDTO dto) {
        ContratoResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}