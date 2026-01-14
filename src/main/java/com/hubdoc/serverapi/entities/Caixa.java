package com.hubdoc.serverapi.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_caixa")
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String codigoEtiqueta;
    private String localizacaoFisica;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    @OneToMany(mappedBy = "caixa")
    private List<Maco> macosDaCaixa = new ArrayList<>();

    public Caixa() {
    }

    public Caixa(Long id, String codigoEtiqueta, String localizacaoFisica, Contrato contrato, List<Maco> macosDaCaixa) {
        this.id = id;
        this.codigoEtiqueta = codigoEtiqueta;
        this.localizacaoFisica = localizacaoFisica;
        this.contrato = contrato;
        this.macosDaCaixa = macosDaCaixa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoEtiqueta() {
        return codigoEtiqueta;
    }

    public void setCodigoEtiqueta(String codigoEtiqueta) {
        this.codigoEtiqueta = codigoEtiqueta;
    }

    public String getLocalizacaoFisica() {
        return localizacaoFisica;
    }

    public void setLocalizacaoFisica(String localizacaoFisica) {
        this.localizacaoFisica = localizacaoFisica;
    }
}
