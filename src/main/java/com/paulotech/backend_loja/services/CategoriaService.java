package com.paulotech.backend_loja.services;

import com.paulotech.backend_loja.entity.Categoria;
import com.paulotech.backend_loja.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarCategoria(){
        return categoriaRepository.findAll();
    }

    public Categoria incluir(Categoria categoria){
        categoria.setDataCriacao(new Date());
        Categoria novaCategoria = categoriaRepository.save(categoria);
        return novaCategoria;
    }

    public Categoria alterar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void excluir(Long id){
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }
}
