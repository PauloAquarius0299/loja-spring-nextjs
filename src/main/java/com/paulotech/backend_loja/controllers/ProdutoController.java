package com.paulotech.backend_loja.controllers;

import com.paulotech.backend_loja.entity.Produto;
import com.paulotech.backend_loja.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    public ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> buscarProdutos() {
        return produtoService.buscarProdutos();
    }

    @PostMapping("/")
    public Produto incluir(@RequestBody Produto produto) {
        return produtoService.incluir(produto);
    }

    @PutMapping("/")
    public Produto alterar(@RequestBody Produto produto) {
        return produtoService.alterar(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        produtoService.exluir(id);
        return ResponseEntity.ok().build();
    }
}
