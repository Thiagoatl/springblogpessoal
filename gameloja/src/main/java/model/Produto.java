package model;
import java.math.BigDecimal;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O atributo nome é obrigatório")
	private String nome;
	
	@NotNull(message = "O Atributo Descrição é obrigatório")
	private String descricao;
	
	@NotNull(message = "O atributo preço é obrigatório")
	@PositiveOrZero
	private BigDecimal preco;
	
	private String foto;
	
	@NotNull(message = "O atributo platagorma é obrigatório")
	private String plataforma;
	
	@NotNull(message = "O atributo data é obrigatório")
	private Date data_lancamento;

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
