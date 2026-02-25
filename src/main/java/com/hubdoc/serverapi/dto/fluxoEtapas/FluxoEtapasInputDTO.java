package com.hubdoc.serverapi.dto.fluxoEtapas;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FluxoEtapasInputDTO {
    private Integer ordem;
    private Long contratoId;
    private Long etapaId;
}
