package com.hubdoc.serverapi.dto;

import com.hubdoc.serverapi.domain.entities.Documento;
import com.hubdoc.serverapi.domain.enums.StatusGlobal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DocumentoDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private String uuid;
    private StatusGlobal statusGlobal;

    public DocumentoDTO(Documento entity) {
        this.id = entity.getId();
        this.uuid = entity.getUuid();
        this.statusGlobal = entity.getStatusGlobal();
    }
}
