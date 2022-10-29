package br.com.vinhos.projetovinhos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinhos.projetovinhos.dto.ClienteDTO;
import br.com.vinhos.projetovinhos.exception.NotFoundException;
import br.com.vinhos.projetovinhos.service.ClienteService;

@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<ClienteDTO> lista() {
		return clienteService.lista();
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> cadastrar(@Valid @RequestBody ClienteDTO cliente) {
		return new ResponseEntity<ClienteDTO>(clienteService.cadastrar(cliente), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ClienteDTO buscarPorID(@PathVariable Long id) throws NotFoundException {
		return clienteService.buscarPorID(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) throws NotFoundException {
		clienteService.excluir(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteDTO cliente) {
		return ResponseEntity.ok(clienteService.atualizar(id, cliente));
	}

}
