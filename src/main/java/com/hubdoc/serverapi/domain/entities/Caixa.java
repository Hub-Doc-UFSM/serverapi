package com.hubdoc.serverapi.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_caixa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(unique = true)
    private String codigoEtiqueta;
    private String localizacaoFisica;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    @OneToMany(mappedBy = "caixa")
    private List<Maco> macosDaCaixa = new ArrayList<>();

}
