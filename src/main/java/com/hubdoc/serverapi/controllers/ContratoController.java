package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.services.ContratoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contratos")
public class ContratoController {

    private ContratoService service;

}
