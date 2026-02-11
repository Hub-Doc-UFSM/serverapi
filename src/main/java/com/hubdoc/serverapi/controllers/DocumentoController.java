package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.dto.documento.DocumentoInputDTO;
import com.hubdoc.serverapi.dto.documento.DocumentoResponseDTO;
import com.hubdoc.serverapi.services.DocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.net.URI;

@RestController
@RequestMapping(value = "/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService service;

    @GetMapping
    public ResponseEntity<Page<DocumentoResponseDTO>> findAll(Pageable pageable) {
        Page<DocumentoResponseDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DocumentoResponseDTO> findById(@PathVariable Long id) {
        DocumentoResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{uuid}/etiqueta-pdf")
    public ResponseEntity<byte[]> downloadEtiqueta(@PathVariable String uuid) {
        String pdfContent = "%PDF-1.4\n1 0 obj<</Type/Catalog/Pages 2 0 R>>endobj 2 0 obj<</Type/Pages/Kids[3 0 R]/Count 1>>endobj 3 0 obj<</Type/Page/MediaBox[0 0 595 842]/Parent 2 0 R/Resources<<>>>>endobj xref 0 4 0000000000 65535 f 0000000010 00000 n 0000000060 00000 n 0000000115 00000 n trailer<</Size 4/Root 1 0 R>>startxref 225 %%EOF";
        byte[] pdfBytes = pdfContent.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "etiqueta-" + uuid + ".pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(pdfBytes, headers, org.springframework.http.HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DocumentoResponseDTO> insert(@RequestBody DocumentoInputDTO dto) {
        DocumentoResponseDTO response = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DocumentoResponseDTO> update(@PathVariable Long id, @RequestBody DocumentoInputDTO dto) {
        DocumentoResponseDTO response = service.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
