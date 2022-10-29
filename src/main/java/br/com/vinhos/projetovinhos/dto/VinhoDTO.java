package br.com.vinhos.projetovinhos.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.vinhos.projetovinhos.entity.Vinho;

public class VinhoDTO {

	private Long id;

	@NotNull(message = "Campo código produto não pode estar vazio.")
	private Long codigoProduto;

	@NotBlank(message = "Campo vinícola não pode estar vazio.")
	private String vinicola;

	@NotBlank(message = "Campo nome produto não pode estar vazio.")
	private String nomeProduto;

	@NotBlank(message = "Campo variedade uva não pode estar vazio.")
	private String variedadeUva;

	public VinhoDTO() {
	}

	public VinhoDTO(Vinho vinho) {
		this.id = vinho.getId();
		this.codigoProduto = vinho.getCodigoProduto();
		this.vinicola = vinho.getVinicola();
		this.nomeProduto = vinho.getNomeProduto();
		this.variedadeUva = vinho.getVariedadeUva();
	}

	public Long getId() {
		return id;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public String getVinicola() {
		return vinicola;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public String getVariedadeUva() {
		return variedadeUva;
	}

	public static List<VinhoDTO> toList(List<Vinho> vinhos) {
		return vinhos.stream().map(VinhoDTO::new).collect(Collectors.toList());
	}

	public Vinho toEntity() {
		return new Vinho(id, codigoProduto, vinicola, nomeProduto, variedadeUva);
	}

}
