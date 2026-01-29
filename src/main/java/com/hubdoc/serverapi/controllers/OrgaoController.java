package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.DocumentoDTO;
import com.hubdoc.serverapi.dto.OrgaoDTO;
import com.hubdoc.serverapi.services.OrgaoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
