package br.com.vinhos.projetovinhos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vinho")
public class Vinho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private Long codigoProduto;

	@Column(nullable = false, length = 255, unique = false)
	private String vinicola;

	@Column(nullable = false, length = 255, unique = false)
	private String nomeProduto;

	@Column(nullable = false, length = 255, unique = false)
	private String variedadeUva;

	public Vinho() {
	}

	public Vinho(Long id, Long codigoProduto, String vinicola, String nomeProduto, String variedadeUva) {
		this.id = id;
		this.codigoProduto = codigoProduto;
		this.vinicola = vinicola;
		this.nomeProduto = nomeProduto;
		this.variedadeUva = variedadeUva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getVinicola() {
		return vinicola;
	}

	public void setVinicola(String vinicola) {
		this.vinicola = vinicola;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getVariedadeUva() {
		return variedadeUva;
	}

	public void setVariedadeUva(String variedadeUva) {
		this.variedadeUva = variedadeUva;
	}

}
