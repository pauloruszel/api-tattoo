package com.br.api_tattoo.interfaces.controller;

import com.br.api_tattoo.application.service.ProdutoService;
import com.br.api_tattoo.domain.model.Produto;
import com.br.api_tattoo.interfaces.dto.ProdutoDTO;
import com.br.api_tattoo.interfaces.dto.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoMapper produtoMapper;


    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = produtoMapper.toEntity(produtoDTO);
        Produto produtoCriado = produtoService.createProduto(produto);
        return ResponseEntity.ok(produtoMapper.toDTO(produtoCriado));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> obterTodosProdutos() {
        List<Produto> produtos = produtoService.getTodosProdutos();
        List<ProdutoDTO> produtoDTOs = produtos.stream().map(produtoMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(produtoDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> obterProdutoPorId(@PathVariable UUID id) {
        Produto produto = produtoService.getProdutoById(id);
        return ResponseEntity.ok(produtoMapper.toDTO(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable UUID id, @RequestBody ProdutoDTO produtoDTO) {
        Produto detalhesProduto = produtoMapper.toEntity(produtoDTO);
        Produto produtoAtualizado = produtoService.atualizaProduto(id, detalhesProduto);
        return ResponseEntity.ok(produtoMapper.toDTO(produtoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable UUID id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}
