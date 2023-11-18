package com.andre.springrediscache.controllers;

import com.andre.springrediscache.domain.ProdutoDTO;
import com.andre.springrediscache.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> saveProduto(@RequestBody ProdutoDTO dto) {
        return ResponseEntity.ok(service.saveProduto(dto));
    }
}