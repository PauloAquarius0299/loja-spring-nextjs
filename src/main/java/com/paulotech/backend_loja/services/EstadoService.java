package com.paulotech.backend_loja.services;

import com.paulotech.backend_loja.entity.Estado;
import com.paulotech.backend_loja.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos(){
        return estadoRepository.findAll();
    }

    public Estado inserir(Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.save(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado estado) {
        estado.setDataAtualizacao(new Date());
        return estadoRepository.save(estado);
    }

    public void excluir(Long id){
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }

}
