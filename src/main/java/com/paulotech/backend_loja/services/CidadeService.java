package com.paulotech.backend_loja.services;

import com.paulotech.backend_loja.entity.Cidade;
import com.paulotech.backend_loja.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    public CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos() {return cidadeRepository.findAll();}

    public Cidade inserir (Cidade cidade){
        cidade.setDataCriacao(new Date());
        Cidade cidadeNova = cidadeRepository.save(cidade);
        return cidadeNova;
    }

    public Cidade atualizar (Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        return cidadeRepository.save(cidade);
    }

    public void excluir(Long id){
        Cidade cidade = cidadeRepository.findById(id).get();
        cidadeRepository.delete(cidade);
    }

}
