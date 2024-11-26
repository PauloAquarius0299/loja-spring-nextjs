package com.paulotech.backend_loja.repositories;

import com.paulotech.backend_loja.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
