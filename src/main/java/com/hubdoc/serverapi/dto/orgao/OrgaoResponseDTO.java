package com.hubdoc.serverapi.dto.orgao;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrgaoResponseDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String sigla;
}

