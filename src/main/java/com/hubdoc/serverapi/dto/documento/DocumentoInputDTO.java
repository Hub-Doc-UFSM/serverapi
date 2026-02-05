package com.hubdoc.serverapi.dto.documento;

import com.hubdoc.serverapi.domain.enums.StatusGlobal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DocumentoInputDTO {

    private String uuid;
    private StatusGlobal statusGlobal;
    private Long macoId;

}
