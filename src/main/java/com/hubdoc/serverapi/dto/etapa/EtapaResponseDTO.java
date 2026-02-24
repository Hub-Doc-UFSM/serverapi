package com.hubdoc.serverapi.dto.etapa;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EtapaResponseDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String descricao;
}
