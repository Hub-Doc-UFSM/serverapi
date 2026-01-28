package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.repositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgaoService {

    @Autowired
    private OrgaoRepository repository;

}
