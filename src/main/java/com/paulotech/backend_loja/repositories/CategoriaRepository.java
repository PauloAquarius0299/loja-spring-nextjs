package com.paulotech.backend_loja.repositories;

import com.paulotech.backend_loja.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
