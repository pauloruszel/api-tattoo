package com.br.api_tattoo.application.service;

import com.br.api_tattoo.domain.model.Produto;
import com.br.api_tattoo.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository ProdutoRepository;

    public Produto createProduto(Produto Produto) {
        return ProdutoRepository.save(Produto);
    }

    public List<Produto> getTodosProdutos() {
        return ProdutoRepository.findAll();
    }

    public Produto getProdutoById(UUID id) {
        return ProdutoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto atualizaProduto(UUID id, Produto ProdutoDetails) {
        Produto Produto = ProdutoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Produto.setNome(ProdutoDetails.getNome());
        Produto.setDescricao(ProdutoDetails.getDescricao());
        Produto.setTipo(ProdutoDetails.getTipo());
        Produto.setPreco(ProdutoDetails.getPreco());

        return ProdutoRepository.save(Produto);
    }

    public void deleteProduto(UUID id) {
        Produto Produto = ProdutoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        ProdutoRepository.delete(Produto);
    }


}
