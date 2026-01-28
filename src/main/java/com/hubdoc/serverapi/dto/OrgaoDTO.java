package com.hubdoc.serverapi.dto;

import com.hubdoc.serverapi.domain.entities.Documento;
import com.hubdoc.serverapi.domain.entities.Orgao;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrgaoDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String sigla;

    public OrgaoDTO(Orgao entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.sigla = entity.getSigla();
    }
}
