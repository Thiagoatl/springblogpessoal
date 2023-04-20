package repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{
	List<Categoria> findAllByTipoContainingIgnoreCase(@Param("tipo") String tipo);
}

