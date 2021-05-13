package com.cadcliente.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadcliente.api.models.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	List<Cliente> findByCadastroAtivo(boolean cadastroAtivo);
}
