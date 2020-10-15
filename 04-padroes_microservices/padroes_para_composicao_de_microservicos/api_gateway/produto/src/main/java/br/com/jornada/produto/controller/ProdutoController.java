package br.com.jornada.produto.controller;

import br.com.jornada.produto.domain.Produto;
import br.com.jornada.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Optional<Produto> prod = service.getById(id);
        if (prod.isPresent()) {
            return new ResponseEntity(prod, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Produto> findAll(){
        return service.getAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Produto save(@RequestBody Produto produto){
        return service.save(produto);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        Optional<Produto> prod = service.getById(id);
        if (prod.isPresent()) {
            Produto p = prod.get();
            p.setNome(produto.getNome());
            p.setNome(produto.getNome());
            return new ResponseEntity(service.save(p),HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}