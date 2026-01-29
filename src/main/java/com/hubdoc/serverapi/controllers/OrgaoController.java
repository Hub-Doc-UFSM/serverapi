package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.OrgaoDTO;
import com.hubdoc.serverapi.services.OrgaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/orgaos")
public class OrgaoController {

    @Autowired
    private OrgaoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrgaoDTO> findById(@PathVariable Long id){
        OrgaoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<OrgaoDTO>> findAll(Pageable pageable) {
        Page<OrgaoDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
    @PostMapping
    public ResponseEntity<OrgaoDTO> insert(@Valid @RequestBody OrgaoDTO dto) {
        OrgaoDTO newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }
}
