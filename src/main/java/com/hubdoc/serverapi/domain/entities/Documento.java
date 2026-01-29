package com.hubdoc.serverapi.domain.entities;

import com.hubdoc.serverapi.domain.enums.StatusGlobal;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_documento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maco_id")
    private Maco maco;
    private String uuid;
    private StatusGlobal statusGlobal;

    @OneToOne(mappedBy = "documento", cascade = CascadeType.ALL)
    private ParecerArquivistico parecerArquivistico;

    @OneToMany(mappedBy = "documento")
    private List<EtapasRealizadas> etapasRealizadas = new ArrayList<>();
}
