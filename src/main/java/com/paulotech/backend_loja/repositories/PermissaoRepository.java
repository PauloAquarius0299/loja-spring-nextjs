package com.paulotech.backend_loja.repositories;

import com.paulotech.backend_loja.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
