package com.cadcliente.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cadcliente.api.error.ResourceNotFoundException;
import com.cadcliente.api.models.Cliente;
import com.cadcliente.api.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Cadastro de Clientes")
@CrossOrigin(origins="*")
public class ClienteResource {

	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/")
	public String paginaInicial() {
		return "API REST de cadastro de clientes";
	}
	
	@GetMapping("/clientes")
	@ApiOperation(value="Este método lista todos os clientes")
	public List<Cliente> listaClientes(){
		
		List<Cliente> clientes = clienteRepository.findAll();
		
		if (clientes == null || clientes.isEmpty()) {
			throw new ResourceNotFoundException("Nenhum cliente encontrado!");
		}
		
		return clientes;
	}

	@GetMapping("/clientesAtivos")
	@ApiOperation(value="Este método lista todos os clientes ativos")
	public List<Cliente> listaClientesAtivos(){
		
		List<Cliente> clientes = clienteRepository.findByCadastroAtivo(true);
		
		if (clientes == null || clientes.isEmpty()) {
			throw new ResourceNotFoundException("No momento não existe nenhum cliente ativo");
		}
		
		return clientes;
		
	}
	
	@PostMapping("/clientes")
	@ApiOperation(value="Este método inclui um novo cliente")
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		try {
			return clienteRepository.save(cliente);
		}catch (Exception ex) {
			throw new ResourceNotFoundException(ex, "Erro ao incluir um cliente");
		}
	}

	@DeleteMapping("/clientes")
	@ApiOperation(value="Este método apaga um cliente")
	public boolean deletaCliente() {
		long id = 0;
		try {
			clienteRepository.deleteById(id);
			return true;
		}catch (EmptyResultDataAccessException emt){
			throw new ResourceNotFoundException("Cliente não encomtrado");
		}catch (MethodArgumentTypeMismatchException ma){
			throw new ResourceNotFoundException("Id do cliente inválido");
		}catch (Exception ex) {
			throw new ResourceNotFoundException(ex, "Erro ao deletar");
		}
		
	}

	@PutMapping("/clientes")
	@ApiOperation(value="Este método atualiza os dados de um cliente")
	public Cliente atualizaCliente(@RequestBody Cliente cliente) {
		try {
			return clienteRepository.save(cliente);
		}catch (Exception ex) {
			throw new ResourceNotFoundException(ex, "Erro ao incluir um cliente");
		}
	}

	
}
