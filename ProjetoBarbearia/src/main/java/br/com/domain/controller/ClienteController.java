package br.com.domain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.domain.model.entities.Cliente;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvarCliente(Cliente cliente) {
		return null;
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Cliente atualizarCliente(@PathVariable("id") Integer id, Cliente cliente) {
		return null;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCliente(Integer id) {

	}

	@GetMapping("/{id}")
	public Cliente buscarClientePorId(Integer id) {
		return null;
	}

}
