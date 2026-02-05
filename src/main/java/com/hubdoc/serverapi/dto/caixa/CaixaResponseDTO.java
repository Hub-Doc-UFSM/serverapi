package com.hubdoc.serverapi.dto.caixa;

import com.hubdoc.serverapi.dto.contrato.ContratoResponseDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CaixaResponseDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private String codigoEtiqueta;
    private ContratoResponseDTO contrato;
}
