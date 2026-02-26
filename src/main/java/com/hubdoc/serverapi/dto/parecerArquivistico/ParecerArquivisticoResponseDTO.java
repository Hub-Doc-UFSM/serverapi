package com.hubdoc.serverapi.dto.parecerArquivistico;

import com.hubdoc.serverapi.domain.enums.EstadoConservacao;
import com.hubdoc.serverapi.dto.documento.DocumentoResponseDTO;
import com.hubdoc.serverapi.dto.usuario.UsuarioResponseDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ParecerArquivisticoResponseDTO {

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
    private String observacoesGerais;
    private DocumentoResponseDTO documento;
    private UsuarioResponseDTO usuario;

}
