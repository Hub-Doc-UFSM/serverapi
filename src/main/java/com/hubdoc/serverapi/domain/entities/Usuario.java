package com.hubdoc.serverapi.domain.entities;

import com.hubdoc.serverapi.domain.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;
    private String codigoDeBarras;
    private String senha;
    private Boolean ativo;
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<ParecerArquivistico> parecerArquivisticos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<EtapasRealizadas> etapasRealizadas = new ArrayList<>();

}
