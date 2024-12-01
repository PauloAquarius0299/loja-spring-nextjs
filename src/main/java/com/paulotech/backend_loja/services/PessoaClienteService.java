package com.paulotech.backend_loja.services;

import com.paulotech.backend_loja.dto.PessoaClienteRequestDTO;
import com.paulotech.backend_loja.entity.Pessoa;
import com.paulotech.backend_loja.repositories.PermissaoRepository;
import com.paulotech.backend_loja.repositories.PessoaClienteRepository;
import com.paulotech.backend_loja.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PessoaClienteService {
    @Autowired
    private PessoaClienteRepository pessoaRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private EmailService emailService;

    public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO){
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova  = pessoaRepository.save(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNova);
        //emailService.enviarEmailTexto(pessoaNova.getEmail(), "Cadastro na loja ShopXpress", "O cadastro na nossa loja foi realizado com sucesso!! Em breve você receberá a senha de acesso pelo seu email");
        Map<String, Object> proprMap = new HashMap<>();
        proprMap.put("nome", pessoaNova.getNome());
        proprMap.put("messagem", "Cadastro na loja ShopXpress. O cadastro na nossa loja foi realizado com sucesso!! Em breve você receberá a senha de acesso pelo seu email");
        emailService.enviarEmailTemplate(pessoaNova.getEmail(), "Cadastro na loja ShopXpress", proprMap);
        return pessoaNova;
    }

}
