package com.hubdoc.serverapi.dto.contrato;

import com.hubdoc.serverapi.dto.orgao.OrgaoResponseDTO;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContratoResponseDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private String codigoContrato;
    private LocalDate dataInicio;
    private Boolean ativo;
    private OrgaoResponseDTO orgao;
}
