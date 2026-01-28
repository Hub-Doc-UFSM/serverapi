package com.hubdoc.serverapi.controllers;

import com.hubdoc.serverapi.services.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orgaos")
public class OrgaoController {

    @Autowired
    private OrgaoService service;


}
