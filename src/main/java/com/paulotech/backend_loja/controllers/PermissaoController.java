package com.paulotech.backend_loja.controllers;

import com.paulotech.backend_loja.entity.Permissao;
import com.paulotech.backend_loja.services.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> buscarPermissao(){return permissaoService.buscarPermissao();}

    @PostMapping("/")
    public Permissao incluir(@RequestBody Permissao permissao){
        return permissaoService.incluir(permissao);
    }

    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao permissao){
        return permissaoService.alterar(permissao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
