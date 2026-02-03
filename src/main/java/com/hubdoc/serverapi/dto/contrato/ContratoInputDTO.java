package com.hubdoc.serverapi.dto.contrato;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContratoInputDTO {
    private String codigoContrato;
    private LocalDate dataInicio;
    private Boolean ativo;
    private Long orgaoId;
}