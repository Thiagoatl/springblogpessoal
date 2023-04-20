package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

		List<Produto> findByProdutoContainingIgnoreCase(@Param("produto") String produto);

		Object findAllByDescricaoContainingIgnoreCase(String descricao);

}