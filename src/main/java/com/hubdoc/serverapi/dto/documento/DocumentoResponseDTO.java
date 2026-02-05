package com.hubdoc.serverapi.dto.documento;

import com.hubdoc.serverapi.domain.enums.StatusGlobal;
import com.hubdoc.serverapi.dto.maco.MacoResponseDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DocumentoResponseDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private MacoResponseDTO maco;
    private String uuid;
    private StatusGlobal statusGlobal;
}
