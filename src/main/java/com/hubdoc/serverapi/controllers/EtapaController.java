package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.etapa.EtapaInputDTO;
import com.hubdoc.serverapi.dto.etapa.EtapaResponseDTO;
import com.hubdoc.serverapi.services.EtapaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/etapas")
@RequiredArgsConstructor
public class EtapaController {

    private final EtapaService service;

    @GetMapping
    public ResponseEntity<Page<EtapaResponseDTO>> findAll(Pageable pageable) {
        Page<EtapaResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EtapaResponseDTO> findById(@PathVariable Long id) {
        EtapaResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EtapaResponseDTO> insert(@RequestBody EtapaInputDTO dto) {
        EtapaResponseDTO response = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EtapaResponseDTO> update(@PathVariable Long id, @RequestBody EtapaInputDTO dto) {
        EtapaResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
