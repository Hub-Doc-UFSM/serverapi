package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.usuario.UsuarioInputDTO;
import com.hubdoc.serverapi.dto.usuario.UsuarioResponseDTO;
import com.hubdoc.serverapi.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> findAll(Pageable pageable) {
        Page<UsuarioResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> findById(@PathVariable Long id) {
        UsuarioResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> insert(@RequestBody UsuarioInputDTO dto) {
        UsuarioResponseDTO response = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@PathVariable Long id, @RequestBody UsuarioInputDTO dto) {
        UsuarioResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
