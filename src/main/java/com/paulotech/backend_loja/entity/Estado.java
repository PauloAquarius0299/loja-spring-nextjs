package com.paulotech.backend_loja.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "estado")
@Data
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String sigla;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public void setDataCriacao(Date date) {
        this.dataCriacao = date;
    }

    public void setDataAtualizacao(Date date) {
        this.dataAtualizacao = date;
    }
}
