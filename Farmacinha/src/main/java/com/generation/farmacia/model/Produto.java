package com.generation.farmacia.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "o atributo nome é obrigatório")
	@Size(min = 5, max = 500, message = "O atributo nome deve possuir no mínimo 5 caracteres e no máximo 100")
	private String nome;
	
	@NotNull(message = "o atributo descricao é obrigatório")
	@Size(min = 5, max = 500, message = "O atributo descricao deve possuir no mínimo 5 caracteres e no máximo 100")
	private String descricao;
	
	@NotNull(message = "o atributo descricao é obrigatório")
	private BigDecimal preco;
	
	@NotNull(message = "o atributo descricao é obrigatório")
	private Long estoque;
	
	@NotNull(message = "o atributo nome é obrigatório")
	@Size(min = 5, max = 500, message = "O atributo nome deve possuir no mínimo 5 caracteres e no máximo 100")
	private String fabricante;
	
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getEstoque() {
		return estoque;
	}

	public void setEstoque(Long estoque) {
		this.estoque = estoque;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	
}
