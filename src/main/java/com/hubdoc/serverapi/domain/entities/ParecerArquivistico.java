package com.hubdoc.serverapi.domain.entities;

import com.hubdoc.serverapi.domain.enums.EstadoConservacao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_parecer_arquivistico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ParecerArquivistico {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    private LocalDateTime dataParecer;
    private Boolean rasgado;
    private Boolean semPerdaInfo;
    private Boolean manchas;
    private Boolean comPerdaInfo;
    private Boolean danoFerrugem;
    private Boolean paginasFaltando;
    private Boolean acidificado;
    private Boolean paginasColadas;
    private Boolean porosoQuebradico;
    private EstadoConservacao estadoConservacao;
    private String indicacaoReparacao;

    @Column(columnDefinition = "TEXT")
    private String observacoesGerais;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Documento documento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
