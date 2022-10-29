package br.com.vinhos.projetovinhos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinhos.projetovinhos.dto.VinhoDTO;
import br.com.vinhos.projetovinhos.entity.Vinho;
import br.com.vinhos.projetovinhos.exception.NotFoundException;
import br.com.vinhos.projetovinhos.repository.VinhoRepository;

@Service
public class VinhoService {

	@Autowired
	private VinhoRepository vinhoRepository;

	public VinhoDTO cadastrar(VinhoDTO vinhoDTO) {
		Vinho vinhoParaSalvar = vinhoDTO.toEntity();
		Vinho vinhoCadastrado = vinhoRepository.save(vinhoParaSalvar);
		vinhoRepository.save(vinhoCadastrado);
		return new VinhoDTO(vinhoParaSalvar);
	}

	public List<VinhoDTO> lista() {
		List<Vinho> vinhos = vinhoRepository.findAll();
		return VinhoDTO.toList(vinhos);
	}

	public VinhoDTO buscarPorID(Long id) throws NotFoundException {
		Optional<Vinho> vinho = vinhoRepository.findById(id);
		if (vinho.isPresent()) {
			return new VinhoDTO(vinho.get());
		}

		throw new NotFoundException("Vinho não encontrado para o id " + id);
	}

	public void excluir(Long id) throws NotFoundException {
		Optional<Vinho> vinho = vinhoRepository.findById(id);
		if (vinho.isPresent()) {
			vinhoRepository.deleteById(id);
		} else {
			throw new NotFoundException("Vinho não encontrado para o id " + id);
		}
	}

	public VinhoDTO atualizar(Long id, VinhoDTO vinhoDTO) {
		Vinho vinhoParaAtualizar = vinhoRepository.findById(id).get();
		vinhoParaAtualizar.setCodigoProduto(vinhoDTO.getCodigoProduto());
		vinhoParaAtualizar.setVinicola(vinhoDTO.getVinicola());
		vinhoParaAtualizar.setNomeProduto(vinhoDTO.getNomeProduto());
		vinhoParaAtualizar.setVariedadeUva(vinhoDTO.getVariedadeUva());
		Vinho vinhoAlterado = vinhoRepository.save(vinhoParaAtualizar);
		return new VinhoDTO(vinhoAlterado);
	}

}
