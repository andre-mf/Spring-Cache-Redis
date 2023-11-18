package com.andre.springrediscache.repositories;

import com.andre.springrediscache.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
