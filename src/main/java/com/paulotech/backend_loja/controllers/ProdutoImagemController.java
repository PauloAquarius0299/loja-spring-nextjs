package com.paulotech.backend_loja.controllers;

import com.paulotech.backend_loja.entity.ProdutoImagem;
import com.paulotech.backend_loja.services.ProdutoImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/produtoImagens")
public class ProdutoImagemController {

    @Autowired
    private ProdutoImagemService produtoImagemService;

    @GetMapping("/")
    public List<ProdutoImagem> buscarImagem(){
        return produtoImagemService.buscarImagem();
    }

    @PostMapping("/")
    public ProdutoImagem inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("File") MultipartFile file){
        if (file.isEmpty()) {
            throw new IllegalArgumentException("O arquivo não pode estar vazio!");
        }
        return produtoImagemService.inserir(idProduto,file);
    }

    @PutMapping("/")
    public ProdutoImagem alterar(@RequestBody ProdutoImagem produtoImagem){
        return produtoImagemService.alterar(produtoImagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        produtoImagemService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
