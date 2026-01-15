package com.hubdoc.serverapi.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maco_id")
    private Maco maco;
    private String uuid;
//  private StatusGlobal statusGlobal;


}
