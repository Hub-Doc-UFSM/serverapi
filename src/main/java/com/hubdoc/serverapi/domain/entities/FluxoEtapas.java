package com.hubdoc.serverapi.domain.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_fluxo_etapas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FluxoEtapas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private Integer ordem;

    @ManyToOne
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;

    @ManyToOne
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

}
