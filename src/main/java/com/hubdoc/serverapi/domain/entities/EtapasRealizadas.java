package com.hubdoc.serverapi.domain.entities;


import com.hubdoc.serverapi.domain.enums.StatusExecucao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_etapas_realizadas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EtapasRealizadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    @Column(columnDefinition = "TEXT")
    private String observacaoTecnica;

    private StatusExecucao status;

    @ManyToOne
    @JoinColumn(name = "documento_id")
    private Documento documento;

    @ManyToOne
    @JoinColumn(name = "etapa_id")
    private Etapa etapa;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
