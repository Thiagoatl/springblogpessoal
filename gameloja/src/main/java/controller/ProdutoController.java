package controller;

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

import jakarta.validation.Valid;
import model.Produto;
import repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;
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
	
	 @GetMapping("/produtos/{nome}")
	    public ResponseEntity<List<Produto>> getBynome(@PathVariable 
	    String nome){
	        return ResponseEntity.ok(produtoRepository
	            .findByProdutoContainingIgnoreCase(nome));
	    }
	
	 @PostMapping
		public ResponseEntity<Produto> post (@Valid @RequestBody Produto produto){
			return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
		
		}
	 
	 @PutMapping
		public ResponseEntity<Produto> put (@Valid @RequestBody Produto produto){
			return produtoRepository.findById(produto.getId())
					.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto)))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());	
		}
	 
	 @DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			Optional<Produto> produto = produtoRepository.findById(id);
			
			if(produto.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			produtoRepository.deleteById(id);
			}
}
