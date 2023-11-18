package com.andre.springrediscache.domain;

import java.io.Serializable;

public record ProdutoDTO(Long id, String nome, Double preco) implements Serializable {

    public ProdutoDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco());
    }
}
