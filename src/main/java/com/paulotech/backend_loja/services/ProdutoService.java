package com.paulotech.backend_loja.services;

import com.paulotech.backend_loja.entity.Produto;
import com.paulotech.backend_loja.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    public List<Produto> buscarProdutos(){
        return produtoRepository.findAll();
    }

    public Produto incluir(Produto produto){
        produto.setDataCriacao(new Date());
        Produto novoProduto = produtoRepository.save(produto);
        return novoProduto;
    }

    public Produto alterar(Produto produto){
        return produtoRepository.save(produto);
    }

    public void exluir(Long id){
        Produto produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }
}
