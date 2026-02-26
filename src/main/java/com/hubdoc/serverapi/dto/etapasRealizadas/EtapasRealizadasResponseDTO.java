package com.hubdoc.serverapi.dto.etapasRealizadas;

import com.hubdoc.serverapi.domain.enums.StatusExecucao;
import com.hubdoc.serverapi.dto.documento.DocumentoResponseDTO;
import com.hubdoc.serverapi.dto.etapa.EtapaResponseDTO;
import com.hubdoc.serverapi.dto.usuario.UsuarioResponseDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EtapasRealizadasResponseDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String observacaoTecnica;
    private StatusExecucao status;
    private DocumentoResponseDTO documento;
    private EtapaResponseDTO etapa;
    private UsuarioResponseDTO usuario;
}
