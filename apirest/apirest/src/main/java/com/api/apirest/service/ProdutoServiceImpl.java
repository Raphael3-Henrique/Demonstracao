package com.api.apirest.service;

import com.api.apirest.model.Produto;
import com.api.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll() {
        List<Produto> list = produtoRepository.findAll();

        if (!list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public Produto findById(Long id) {
        Produto produto = produtoRepository.findById(id).get();

        if (produto != null) {
            return produto;
        } else {
            return null;
        }
    }

    @Override
    public Produto save(Produto produto) {
        Produto prod = produtoRepository.save(produto);

        if (prod != null) {
            return prod;
        } else {
            return null;
        }
    }

    @Override
    public Produto delete(Long id) {

        try {
            Produto produto = produtoRepository.findById(id).get();
            if (produto != null) {
                produtoRepository.delete(produto);
                return produto;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}