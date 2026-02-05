package com.hubdoc.serverapi.dto.caixa;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CaixaInputDTO {
    private String codigoEtiqueta;
    private Long contratoId;
}
