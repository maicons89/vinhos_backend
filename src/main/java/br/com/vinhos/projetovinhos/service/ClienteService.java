package br.com.vinhos.projetovinhos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinhos.projetovinhos.dto.ClienteDTO;
import br.com.vinhos.projetovinhos.entity.Cliente;
import br.com.vinhos.projetovinhos.exception.NotFoundException;
import br.com.vinhos.projetovinhos.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteDTO cadastrar(ClienteDTO clienteDTO) {
		Cliente clienteParaSalvar = clienteDTO.toEntity();
		Cliente clienteCadastrado = clienteRepository.save(clienteParaSalvar);
		clienteRepository.save(clienteCadastrado);
		return new ClienteDTO(clienteParaSalvar);
	}

	public List<ClienteDTO> lista() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ClienteDTO.toList(clientes);
	}

	public ClienteDTO buscarPorID(Long id) throws NotFoundException {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return new ClienteDTO(cliente.get());
		}

		throw new NotFoundException("Cliente não encontrado para o id " + id);
	}

	public void excluir(Long id) throws NotFoundException {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			clienteRepository.deleteById(id);
		} else {
			throw new NotFoundException("Cliente não encontrado para o id " + id);
		}
	}

	public ClienteDTO atualizar(Long id, ClienteDTO clienteDTO) {
		Cliente clienteParaAtualizar = clienteRepository.findById(id).get();
		clienteParaAtualizar.setNome(clienteDTO.getNome());
		clienteParaAtualizar.setCpf(clienteDTO.getCpf());
		clienteParaAtualizar.setTelefone(clienteDTO.getTelefone());
		clienteParaAtualizar.setEmail(clienteDTO.getEmail());
		clienteParaAtualizar.setLogradouro(clienteDTO.getLogradouro());
		clienteParaAtualizar.setNumero(clienteDTO.getNumero());
		clienteParaAtualizar.setComplemento(clienteDTO.getComplemento());
		clienteParaAtualizar.setCep(clienteDTO.getCep());
		clienteParaAtualizar.setBairro(clienteDTO.getBairro());
		Cliente clienteAlterado = clienteRepository.save(clienteParaAtualizar);
		return new ClienteDTO(clienteAlterado);
	}

}
