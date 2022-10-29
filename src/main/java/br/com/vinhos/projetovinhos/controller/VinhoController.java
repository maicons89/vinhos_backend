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

import br.com.vinhos.projetovinhos.dto.VinhoDTO;
import br.com.vinhos.projetovinhos.exception.EntidadeEmUsoException;
import br.com.vinhos.projetovinhos.exception.NotFoundException;
import br.com.vinhos.projetovinhos.service.VinhoService;

@RestController
@RequestMapping(value = "/api/vinho")
public class VinhoController {

	@Autowired
	private VinhoService vinhoService;

	@GetMapping
	public List<VinhoDTO> lista() {
		return vinhoService.lista();
	}

	@PostMapping
	public ResponseEntity<VinhoDTO> cadastrar(@Valid @RequestBody VinhoDTO vinho) {
		return new ResponseEntity<VinhoDTO>(vinhoService.cadastrar(vinho), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public VinhoDTO buscarPorID(@PathVariable Long id) throws NotFoundException {
		return vinhoService.buscarPorID(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) throws NotFoundException, EntidadeEmUsoException {
		vinhoService.excluir(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<VinhoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody VinhoDTO vinho) {
		return ResponseEntity.ok(vinhoService.atualizar(id, vinho));
	}

}
