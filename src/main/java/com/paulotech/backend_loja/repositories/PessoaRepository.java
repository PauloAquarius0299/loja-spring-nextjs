package com.paulotech.backend_loja.repositories;

import com.paulotech.backend_loja.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
