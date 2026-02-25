package com.hubdoc.serverapi.dto.fluxoEtapas;

import com.hubdoc.serverapi.dto.contrato.ContratoResponseDTO;
import com.hubdoc.serverapi.dto.etapa.EtapaResponseDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FluxoEtapasResponseDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private Integer ordem;
    private ContratoResponseDTO contrato;
    private EtapaResponseDTO etapa;
}
