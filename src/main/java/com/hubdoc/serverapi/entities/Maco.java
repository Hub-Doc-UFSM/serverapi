package com.hubdoc.serverapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_maco")
public class Maco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "caixa_id")
    private Caixa caixa;
}
