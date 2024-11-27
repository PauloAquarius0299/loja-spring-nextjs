package com.paulotech.backend_loja.controllers;


import com.paulotech.backend_loja.entity.Cidade;
import com.paulotech.backend_loja.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> buscarTodas() {return cidadeService.buscarTodos();}

    @PostMapping("/")
    public Cidade inserir(@RequestBody Cidade cidade){
        return cidadeService.inserir(cidade);
    }

    @PutMapping("/")
    public Cidade atualizar(@RequestBody Cidade cidade){
        return cidadeService.atualizar(cidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cidade> excluir(@PathVariable("id")Long id){
        cidadeService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
