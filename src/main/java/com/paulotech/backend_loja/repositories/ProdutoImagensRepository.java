package com.paulotech.backend_loja.repositories;

import com.paulotech.backend_loja.entity.ProdutoImagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoImagensRepository extends JpaRepository<ProdutoImagem, Long> {
}
