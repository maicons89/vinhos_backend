package br.com.vinhos.projetovinhos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vinhos.projetovinhos.entity.Vinho;

public interface VinhoRepository extends JpaRepository<Vinho, Long> {

}
