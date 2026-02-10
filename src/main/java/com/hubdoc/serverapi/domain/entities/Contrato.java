package com.hubdoc.serverapi.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_contrato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String codigoContrato;
    private LocalDate dataInicio;
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "orgao_id")
    private Orgao orgao;

    @OneToMany(mappedBy = "contrato")
    private List<Caixa> caixas = new ArrayList<>();

    @OneToMany(mappedBy = "contrato")
    private List<FluxoEtapas> etapasContrato = new ArrayList<>();
}
