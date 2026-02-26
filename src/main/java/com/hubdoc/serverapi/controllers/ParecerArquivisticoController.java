package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.parecerArquivistico.ParecerArquivisticoInputDTO;
import com.hubdoc.serverapi.dto.parecerArquivistico.ParecerArquivisticoResponseDTO;
import com.hubdoc.serverapi.services.ParecerArquivisticoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pareceres-arquivisticos")
@RequiredArgsConstructor
public class ParecerArquivisticoController {

    private final ParecerArquivisticoService service;

    @GetMapping
    public ResponseEntity<Page<ParecerArquivisticoResponseDTO>> findAll(Pageable pageable) {
        Page<ParecerArquivisticoResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParecerArquivisticoResponseDTO> findById(@PathVariable Long id) {
        ParecerArquivisticoResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ParecerArquivisticoResponseDTO> insert(@RequestBody ParecerArquivisticoInputDTO dto) {
        ParecerArquivisticoResponseDTO response = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ParecerArquivisticoResponseDTO> update(@PathVariable Long id, @RequestBody ParecerArquivisticoInputDTO dto) {
        ParecerArquivisticoResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
