package com.andre.springrediscache.services;

import com.andre.springrediscache.domain.Produto;
import com.andre.springrediscache.domain.ProdutoDTO;
import com.andre.springrediscache.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<ProdutoDTO> findAll() {
        List<ProdutoDTO> listAll = this.repository.findAll().stream().map(ProdutoDTO::new).toList();
        return listAll;
    }

    public ProdutoDTO saveProduto(ProdutoDTO dto) {
        Produto newProduto = repository.save(new Produto(dto));
        ProdutoDTO produtoDTO = new ProdutoDTO(newProduto);
        return produtoDTO;
    }
}
