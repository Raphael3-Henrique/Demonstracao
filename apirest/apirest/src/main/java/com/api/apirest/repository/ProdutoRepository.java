package com.api.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.apirest.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	Produto findById(long id);

}
