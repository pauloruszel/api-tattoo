package com.br.api_tattoo.interfaces.dto;

import com.br.api_tattoo.domain.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setDescricao(produto.getDescricao());
        dto.setTipo(produto.getTipo());
        dto.setPreco(produto.getPreco());
        return dto;
    }

    public Produto toEntity(ProdutoDTO dto) {
        Produto product = new Produto();
        product.setNome(dto.getNome());
        product.setDescricao(dto.getDescricao());
        product.setTipo(dto.getTipo());
        product.setPreco(dto.getPreco());
        return product;
    }
}
