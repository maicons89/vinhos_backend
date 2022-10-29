package br.com.vinhos.projetovinhos.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.vinhos.projetovinhos.entity.Cliente;

public class ClienteDTO {

	private Long id;

	@NotBlank(message = "Campo nome não pode estar vazio.")
	private String nome;

	@NotBlank(message = "Campo CPF não pode estar vazio.")
	private String cpf;

	@NotBlank(message = "Campo telefone não pode estar vazio.")
	private String telefone;

	@Email(message = "Email inválido.")
	@NotBlank(message = "Campo email não pode estar vazio.")
	private String email;

	@NotBlank(message = "Campo logradouro não pode estar vazio.")
	private String logradouro;

	@NotNull(message = "Campo numero não pode estar vazio.")
	private Long numero;

	private String complemento;

	@NotBlank(message = "Campo cep não pode estar vazio.")
	private String cep;

	@NotBlank(message = "Campo bairro não pode estar vazio.")
	private String bairro;

	@NotBlank(message = "Campo cidade não pode estar vazio.")
	private String cidade;

	@NotBlank(message = "Campo estado não pode estar vazio.")
	private String estado;

	public ClienteDTO() {
	}

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
		this.logradouro = cliente.getLogradouro();
		this.numero = cliente.getNumero();
		this.complemento = cliente.getComplemento();
		this.cep = cliente.getCep();
		this.bairro = cliente.getBairro();
		this.cidade = cliente.getCidade();
		this.estado = cliente.getEstado();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Long getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public static List<ClienteDTO> toList(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

	public Cliente toEntity() {
		return new Cliente(id, nome, cpf, telefone, email, logradouro, numero, complemento, cep, bairro, cidade,
				estado);
	}

}
