package com.paulotech.backend_loja.controllers;

import com.paulotech.backend_loja.entity.Pessoa;
import com.paulotech.backend_loja.services.PessoaGerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/pessoa-gerenciamento")
public class PessoaGerenciamentoController {

    @Autowired
    private PessoaGerenciamentoService pessoaGerenciamentoService;

    @PostMapping("/senha-codigo")
    public String recuperarCodigo(@RequestBody Pessoa pessoa) {
        return pessoaGerenciamentoService.solicitarCodico(pessoa.getEmail());
    }

    @PostMapping("/senha-alterar")
    public String alterarCodigo(@RequestBody Pessoa pessoa) {
        return pessoaGerenciamentoService.alterarSenha(pessoa);
    }

}
