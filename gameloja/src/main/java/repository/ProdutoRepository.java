package repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {
	List <Produto>findAllByNomeContainingIgnoreCase(@Param("nome")String nome);
	
	List<Produto>findByPrecoGreaterThan(BigDecimal preco);

	List<Produto>findByPrecoLessThan(BigDecimal preco);
}