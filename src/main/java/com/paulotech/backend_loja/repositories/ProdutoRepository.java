package com.paulotech.backend_loja.repositories;

import com.paulotech.backend_loja.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
