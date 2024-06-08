package com.br.api_tattoo.domain.repository;

import com.br.api_tattoo.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
