package com.api.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apirest.models.Produtos;
import com.api.apirest.repository.ProdutosRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST")
@CrossOrigin(origins = "*")
public class ProdutosResources {

	@Autowired
	ProdutosRepository produtosRepository;

	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de Produtos")
	public List<Produtos> listaProdutos() {
		return produtosRepository.findAll();

	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um Produto Único")
	public Produtos listaProdutoUnico(@PathVariable(value = "id") long id) {
		return produtosRepository.findById(id);
	}

	@PostMapping("/produto")
	@ApiOperation(value = "Salva um Produto")
	public Produtos salvaProduto(@RequestBody Produtos produto) {
		return produtosRepository.save(produto);
	}

	@DeleteMapping("/produto")
	@ApiOperation(value = "Deleta um Produto")
	public void deletaProduto(@RequestBody Produtos produto) {
		produtosRepository.delete(produto);
	}

	@PutMapping("/produto")
	@ApiOperation(value = "Altera um Produto")
	public Produtos atualizaProduto(@RequestBody Produtos produto) {
		return produtosRepository.save(produto);
	}

}
