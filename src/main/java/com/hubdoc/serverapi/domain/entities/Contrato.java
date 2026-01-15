package com.hubdoc.serverapi.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String codigoContrato;
    private LocalDate dataInicio;
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "orgao_id")
    private Orgao orgao;

    @OneToMany(mappedBy = "contrato")
    private List<Caixa> caixas = new ArrayList<>();

    public Contrato() {
    }

    public Contrato(Long id, String codigoContrato, LocalDate dataInicio, Boolean ativo, Orgao orgao) {
        this.id = id;
        this.codigoContrato = codigoContrato;
        this.dataInicio = dataInicio;
        this.ativo = ativo;
        this.orgao = orgao;
    }


    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
