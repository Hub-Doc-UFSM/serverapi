package com.hubdoc.serverapi.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_etapa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Etapa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @OneToMany(mappedBy = "etapa")
    private List<FluxoEtapas> etapasContrato = new ArrayList<>();

    @OneToMany(mappedBy = "etapa")
    private List<EtapasRealizadas> etapasRealizadas = new ArrayList<>();
}
