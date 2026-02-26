package com.hubdoc.serverapi.dto.etapasRealizadas;

import com.hubdoc.serverapi.domain.enums.StatusExecucao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtapasRealizadasInputDTO {

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String observacaoTecnica;
    private StatusExecucao status;
    private Long documentoId;
    private Long etapaId;
    private Long usuarioId;
}
