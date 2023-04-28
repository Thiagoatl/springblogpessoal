package com.generation.farmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.farmacia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	
	List<Produto>findAllByNomeContainingIgnoreCase(@Param("nome")String nome);
	
	List<Produto>findByPrecoGreaterThan(BigDecimal preco);

	List<Produto>findByPrecoLessThan(BigDecimal preco);
	
	public List<Produto>findAllByPrecoBetween(BigDecimal inicio, BigDecimal fim);
}
