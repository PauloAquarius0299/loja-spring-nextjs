package com.paulotech.backend_loja.controllers;

import com.paulotech.backend_loja.entity.Categoria;
import com.paulotech.backend_loja.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> buscarCategoria(){ return categoriaService.buscarCategoria();}

    @PostMapping("/")
    public Categoria incluir(@RequestBody Categoria categoria){
        return categoriaService.incluir(categoria);
    }

    @PutMapping("/")
    public Categoria alterar(@RequestBody Categoria categoria){
        return categoriaService.alterar(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id")Long id){
        categoriaService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
