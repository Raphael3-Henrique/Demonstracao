package com.api.apirest.service;

import com.api.apirest.model.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findAll();

    Produto findById(Long id);

    Produto save(Produto produto);

    Produto delete(Long id);
}
