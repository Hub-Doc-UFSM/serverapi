package com.hubdoc.serverapi.dto.usuario;

import com.hubdoc.serverapi.domain.enums.TipoUsuario;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UsuarioInputDTO {
    private String nome;
    private String codigoDeBarras;
    private String senha;
    private Boolean ativo;
    private TipoUsuario tipoUsuario;
}
