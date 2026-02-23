package com.hubdoc.serverapi.dto.usuario;

import com.hubdoc.serverapi.domain.enums.TipoUsuario;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UsuarioResponseDTO {

    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String codigoDeBarras;
    private Boolean ativo;
    private TipoUsuario tipoUsuario;
}
