package com.br.api_tattoo.interfaces.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProdutoDTO {
    private UUID id;
    private String nome;
    private String descricao;
    private String tipo;
    private double preco;
}
