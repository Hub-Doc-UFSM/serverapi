package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.fluxoEtapas.FluxoEtapasInputDTO;
import com.hubdoc.serverapi.dto.fluxoEtapas.FluxoEtapasResponseDTO;
import com.hubdoc.serverapi.services.FluxoEtapasService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/fluxo-etapas")
@RequiredArgsConstructor
public class FluxoEtapasController {

    private final FluxoEtapasService service;

    @GetMapping
    public ResponseEntity<Page<FluxoEtapasResponseDTO>> findAll(Pageable pageable) {
        Page<FluxoEtapasResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FluxoEtapasResponseDTO> findById(@PathVariable Long id) {
        FluxoEtapasResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<FluxoEtapasResponseDTO> insert(@RequestBody FluxoEtapasInputDTO dto) {
        FluxoEtapasResponseDTO response = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FluxoEtapasResponseDTO> update(@PathVariable Long id, @RequestBody FluxoEtapasInputDTO dto) {
        FluxoEtapasResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
