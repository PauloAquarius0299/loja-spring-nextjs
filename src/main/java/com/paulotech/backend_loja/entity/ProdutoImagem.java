package com.paulotech.backend_loja.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "produtosImagens")
@Data
@Getter
@Setter
public class ProdutoImagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @ManyToOne
    @JoinColumn(name="idProduto")
    private Produto produto;

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

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setNome(String nomeImagem) {
        this.nome = nome;
    }
}
