package com.hubdoc.serverapi.services;

import com.hubdoc.serverapi.mappers.CaixaMapper;
import com.hubdoc.serverapi.repositories.CaixaRepository;
import com.hubdoc.serverapi.repositories.OrgaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaixaService {

    private final CaixaRepository repository;
    private final OrgaoRepository orgaoRepository;
    private final CaixaMapper mapper;



}
