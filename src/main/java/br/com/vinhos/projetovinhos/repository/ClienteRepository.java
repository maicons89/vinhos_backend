package br.com.vinhos.projetovinhos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vinhos.projetovinhos.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
