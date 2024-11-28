package com.paulotech.backend_loja.controllers;

import com.paulotech.backend_loja.entity.Marca;
import com.paulotech.backend_loja.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> buscarMarca(){
        return marcaService.buscarMarca();
    }

    @PostMapping("/")
    public Marca incluir(@RequestBody Marca marca){
        return marcaService.incluir(marca);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca){
        return marcaService.alterar(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        marcaService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
