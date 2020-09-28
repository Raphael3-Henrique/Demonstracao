package com.api.apirest.controller;

import com.api.apirest.model.Produto;
import com.api.apirest.repository.ProdutoRepository;
import com.api.apirest.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna uma lista de Produtos")
    public ResponseEntity<List<Produto>> listaProdutos() {
        List<Produto> produtoList = produtoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtoList);

    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value = "Retorna um Produto Único")
    public ResponseEntity<Produto> listaProdutoUnico(@PathVariable(value = "id") Long id) {
        Produto produto = produtoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Salva um Produto")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) {
        Produto prod = produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.OK).body(prod);
    }

    @DeleteMapping("/produto/{id}")
    @ApiOperation(value = "Deleta um Produto")
    public ResponseEntity<Produto> deletaProduto(@PathVariable(value = "id") Long id) {
        Produto produto = produtoService.delete(id);
        HttpStatus status = produto == null ? HttpStatus.NOT_MODIFIED : HttpStatus.OK;
        return ResponseEntity.status(status).body(produto);
    }


}
