package com.hubdoc.serverapi.domain.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_maco")
public class Maco {

    public Maco() {
    }

    public Maco(Long id, Caixa caixa, Integer quantidadeFolhas, String descricao, List<Documento> documentos) {
        this.id = id;
        this.caixa = caixa;
        this.quantidadeFolhas = quantidadeFolhas;
        this.descricao = descricao;
        this.documentos = documentos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "caixa_id")
    private Caixa caixa;
    private Integer quantidadeFolhas;
    private String descricao;

    @OneToMany(mappedBy = "maco")
    private List<Documento> documentos = new ArrayList<>();

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadeFolhas() {
        return quantidadeFolhas;
    }

    public void setQuantidadeFolhas(Integer quantidadeFolhas) {
        this.quantidadeFolhas = quantidadeFolhas;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
