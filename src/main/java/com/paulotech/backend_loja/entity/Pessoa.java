package com.paulotech.backend_loja.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pessoa")
@Data
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String codigoRecuperacaoSenha;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvioCodico;
    private String senha;
    private String endereco;
    private String cep;

    @ManyToOne
    @JoinColumn(name="idCidade")
    private Cidade cidade;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoas;

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

    public void setPermissaoPessoas(List<PermissaoPessoa> pp){
        for(PermissaoPessoa p:pp){
            p.setPessoa(this);
        }
        this.permissaoPessoas = pp;
    }

    public String getEmail() {
        return this.email = email;
    }
}
