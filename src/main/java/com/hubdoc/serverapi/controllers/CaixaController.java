package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.caixa.CaixaInputDTO;
import com.hubdoc.serverapi.dto.caixa.CaixaResponseDTO;
import com.hubdoc.serverapi.services.CaixaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/caixas")
@RequiredArgsConstructor
public class CaixaController {

    private final CaixaService service;

    @GetMapping
    public ResponseEntity<Page<CaixaResponseDTO>> findAll(Pageable pageable) {
        Page<CaixaResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CaixaResponseDTO> findById(@PathVariable Long id) {
        CaixaResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<CaixaResponseDTO> insert(@RequestBody CaixaInputDTO dto) {
        CaixaResponseDTO response = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CaixaResponseDTO> update(@PathVariable Long id, @RequestBody CaixaInputDTO dto) {
        CaixaResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
