package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.maco.MacoInputDTO;
import com.hubdoc.serverapi.dto.maco.MacoResponseDTO;
import com.hubdoc.serverapi.services.MacoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/macos")
@RequiredArgsConstructor
public class MacoController {

    private final MacoService service;

    @GetMapping
    public ResponseEntity<Page<MacoResponseDTO>> findAll(Pageable pageable) {
        Page<MacoResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MacoResponseDTO> findById(@PathVariable Long id) {
        MacoResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<MacoResponseDTO> insert(@RequestBody MacoInputDTO dto) {
        MacoResponseDTO response = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MacoResponseDTO> update(@PathVariable Long id, @RequestBody MacoInputDTO dto) {
        MacoResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
