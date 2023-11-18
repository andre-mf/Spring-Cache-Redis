package com.andre.springrediscache.domain;

public record ProdutoDTO(Long id, String nome, Double preco) {

    public ProdutoDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco());
    }
}
