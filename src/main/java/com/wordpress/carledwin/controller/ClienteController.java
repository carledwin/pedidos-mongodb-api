package com.wordpress.carledwin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordpress.carledwin.document.Cliente;
import com.wordpress.carledwin.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	public ResponseEntity<?> criarCliente(@RequestBody Cliente cliente){
		
		cliente = clienteRepository.save(cliente);
		
		if(cliente != null && cliente.getId() != null) {
			
			return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String>("Falha ao tentar salvar cliente", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping
	public ResponseEntity<?> allClientes(){
		
		Iterable<Cliente> todos = clienteRepository.findAll();
		
		if(todos != null) {
			return new ResponseEntity<Iterable<Cliente>>(todos, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
