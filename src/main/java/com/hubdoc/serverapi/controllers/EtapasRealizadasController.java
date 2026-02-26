package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.etapasRealizadas.EtapasRealizadasInputDTO;
import com.hubdoc.serverapi.dto.etapasRealizadas.EtapasRealizadasResponseDTO;
import com.hubdoc.serverapi.services.EtapasRealizadasService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/etapas-realizadas")
@RequiredArgsConstructor
public class EtapasRealizadasController {

    private final EtapasRealizadasService service;

    @GetMapping
    public ResponseEntity<Page<EtapasRealizadasResponseDTO>> findAll(Pageable pageable) {
        Page<EtapasRealizadasResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EtapasRealizadasResponseDTO> findById(@PathVariable Long id) {
        EtapasRealizadasResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EtapasRealizadasResponseDTO> insert(@RequestBody EtapasRealizadasInputDTO dto) {
        EtapasRealizadasResponseDTO response = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EtapasRealizadasResponseDTO> update(@PathVariable Long id, @RequestBody EtapasRealizadasInputDTO dto) {
        EtapasRealizadasResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
