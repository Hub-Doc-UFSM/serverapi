package com.hubdoc.serverapi.dto.maco;

import com.hubdoc.serverapi.dto.caixa.CaixaResponseDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MacoResponseDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private CaixaResponseDTO caixa;
    private Integer quantidadeFolhas;
    private String descricao;
}
