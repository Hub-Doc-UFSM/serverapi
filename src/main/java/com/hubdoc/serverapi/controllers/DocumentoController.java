package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.DocumentoDTO;
import com.hubdoc.serverapi.services.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @GetMapping
    public ResponseEntity<Page<DocumentoDTO>> findAll(Pageable pageable){
        Page<DocumentoDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

}
