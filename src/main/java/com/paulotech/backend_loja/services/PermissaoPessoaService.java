package com.paulotech.backend_loja.services;

import com.paulotech.backend_loja.entity.Permissao;
import com.paulotech.backend_loja.entity.PermissaoPessoa;
import com.paulotech.backend_loja.entity.Pessoa;
import com.paulotech.backend_loja.repositories.PermissaoPessoaRepository;
import com.paulotech.backend_loja.repositories.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    public void vincularPessoaPermissaoCliente(Pessoa pessoa) {
        List<Permissao> listaPermissao = permissaoRepository.findByNome("cliente");

        if (listaPermissao.size() > 0) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.save(permissaoPessoa);
        }
    }
}
