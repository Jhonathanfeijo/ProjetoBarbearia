package br.com.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.domain.model.dto.impl.ClienteDTO;
import br.com.domain.model.dto.response.ClienteResponse;
import br.com.domain.model.entities.Cliente;
import br.com.domain.model.services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteDTO clienteDTO;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponse salvarCliente(@RequestBody Cliente cliente) {
		cliente = clienteService.salvarCliente(cliente);
		return clienteDTO.toClienteResponse(cliente);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCliente(@PathVariable("id") Integer id) {
		clienteService.deletarClientePorId(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ClienteResponse atualizarCliente(@RequestBody Cliente cliente, @PathVariable("id") Integer id) {
		cliente = clienteService.atualizarCliente(cliente, id);
		return clienteDTO.toClienteResponse(cliente);
	}

	@GetMapping("/{id}")
	public ClienteResponse buscarClientePorId(@PathVariable("id") Integer id) {
		Cliente cliente = clienteService.buscarClientePorId(id);
		return clienteDTO.toClienteResponse(cliente);
	}

}
