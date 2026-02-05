package com.hubdoc.serverapi.dto.maco;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MacoInputDTO {
    private Long caixaId;
    private Integer quantidadeFolhas;
    private String descricao;
}
