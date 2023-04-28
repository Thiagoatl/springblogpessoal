package com.generation.farmacia.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.CategoriaRepository;
import com.generation.farmacia.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}			
	
	 @GetMapping("/nome/{nome}")
	    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome){
		 return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	 }
	    
	@PostMapping
	public ResponseEntity<Produto> post (@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put (@Valid @RequestBody Produto produto){
		return produtoRepository.findById(produto.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(produtoRepository.save(produto)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());		
				
	}
	 
	
	 @DeleteMapping("/{id}")
		public void delete(@PathVariable Long id){
		 Optional<Produto> produto = produtoRepository.findById(id);
		 	
		 	if(produto.isEmpty())
		 		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		 	produtoRepository.deleteById(id);
	 }
	 
	 @GetMapping("preco_maior/{preco}")
		public ResponseEntity<List<Produto>> getPrecoMaior (@PathVariable BigDecimal preco){
			return ResponseEntity.ok(produtoRepository.findByPrecoGreaterThan(preco));
		}
		
		@GetMapping("preco_menor/{preco}")
		public ResponseEntity<List<Produto>> getPrecoMenor (@PathVariable BigDecimal preco){
			return ResponseEntity.ok(produtoRepository.findByPrecoLessThan(preco));
		}
		
		
		
		@GetMapping("preco_inicial/{inicio}/preco_final/{fim}")
		public ResponseEntity <List<Produto>> getPrecoBetween (@PathVariable BigDecimal inicio, @PathVariable BigDecimal fim){
			return ResponseEntity.ok(produtoRepository.findAllByPrecoBetween(inicio, fim));
		}
}
