package com.paulotech.backend_loja.services;

import com.paulotech.backend_loja.entity.Permissao;
import com.paulotech.backend_loja.repositories.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    public PermissaoRepository permissaoRepository;

    public List<Permissao> buscarPermissao(){
        return permissaoRepository.findAll();
    }

    public Permissao incluir(Permissao permissao){
        permissao.setDataCriacao(new Date());
        Permissao novaPermissao = permissaoRepository.save(permissao);
        return novaPermissao;
    }

    public Permissao alterar(Permissao permissao){
        permissao.setDataAtualizacao(new Date());
        return permissaoRepository.save(permissao);
    }

    public void excluir (Long id){
        Permissao permissao = permissaoRepository.findById(id).get();
        permissaoRepository.delete(permissao);
    }
}
