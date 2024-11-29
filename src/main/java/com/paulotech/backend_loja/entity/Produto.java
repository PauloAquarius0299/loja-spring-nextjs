package com.paulotech.backend_loja.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "produto")
@Data
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descrincaoCurta;
    private String descrincaoDetalhada;
    private Double valorCusto;
    private Double valorVenda;
    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
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

    public Long getId() {
        return this.id;
    }

}
