package com.api.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.apirest.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	
	Produtos findById(long id);

}
