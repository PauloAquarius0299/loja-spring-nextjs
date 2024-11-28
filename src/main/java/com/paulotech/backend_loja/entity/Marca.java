package com.paulotech.backend_loja.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "marca")
@Data
@Getter
@Setter
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

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
