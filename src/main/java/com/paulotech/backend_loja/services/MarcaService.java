package com.paulotech.backend_loja.services;

import com.paulotech.backend_loja.entity.Marca;
import com.paulotech.backend_loja.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarMarca(){
        return marcaRepository.findAll();
    }

    public Marca incluir(Marca marca){
        marca.setDataCriacao(new Date());
        Marca novaMarca = marcaRepository.save(marca);
        return novaMarca;
    }

    public Marca alterar(Marca marca){
        return marcaRepository.save(marca);
    }

    public void excluir(Long id){
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }
}
