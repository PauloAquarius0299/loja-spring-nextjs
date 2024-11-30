package com.paulotech.backend_loja.controllers;

import com.paulotech.backend_loja.dto.PessoaClienteRequestDTO;
import com.paulotech.backend_loja.entity.Pessoa;
import com.paulotech.backend_loja.services.PessoaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {
    @Autowired
    private PessoaClienteService pessoaService;

    @PostMapping("/")
    public Pessoa inserir(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        return pessoaService.registrar(pessoaClienteRequestDTO);
    }

}
