package com.paulotech.backend_loja.services;

import com.paulotech.backend_loja.entity.Produto;
import com.paulotech.backend_loja.entity.ProdutoImagem;
import com.paulotech.backend_loja.repositories.ProdutoImagensRepository;
import com.paulotech.backend_loja.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProdutoImagemService {

    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagem> buscarImagem(){
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagem inserir(Long idProduto, MultipartFile file){
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagem imagem = new ProdutoImagem();

        try{
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("c:/imagens/" +nomeImagem );
                Files.write(caminho, bytes);
                imagem.setNome(nomeImagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        imagem.setProduto(produto);
        imagem.setDataCriacao(new Date());
        imagem = produtoImagensRepository.save(imagem);
        return imagem;
    }

    public ProdutoImagem alterar(ProdutoImagem produtoImagem){
        return produtoImagensRepository.save(produtoImagem);
    }

    public void excluir(Long id){
        ProdutoImagem produtoImagem = produtoImagensRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("ProdutoImagem não encontrada para o ID: " + id)
        );
        produtoImagensRepository.delete(produtoImagem);
    }
}
