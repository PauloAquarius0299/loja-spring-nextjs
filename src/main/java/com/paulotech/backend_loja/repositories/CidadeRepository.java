package com.paulotech.backend_loja.repositories;

import com.paulotech.backend_loja.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
