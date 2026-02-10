package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.OrgaoDTO;
import com.hubdoc.serverapi.dto.contrato.ContratoResponseDTO;
import com.hubdoc.serverapi.services.ContratoService;
import com.hubdoc.serverapi.services.OrgaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orgaos")
@RequiredArgsConstructor
public class OrgaoController {

    private final OrgaoService service;
    private final ContratoService contratoService;

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
    @PutMapping(value = "/{id}")
    public ResponseEntity<OrgaoDTO> update(@PathVariable Long id, @Valid @RequestBody OrgaoDTO dto) {
        OrgaoDTO newDto = service.update(id, dto);
        return ResponseEntity.ok(newDto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/contratos")
    public ResponseEntity<List<ContratoResponseDTO>> findContratosByOrgao(@PathVariable Long id) {
        List<ContratoResponseDTO> list = contratoService.findByOrgao(id);
        return ResponseEntity.ok(list);
    }
}
