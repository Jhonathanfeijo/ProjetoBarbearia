package br.com.domain.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.domain.model.cliente.Cliente;
import br.com.domain.model.cliente.ClienteDadosCadastro;
import br.com.domain.model.cliente.ClienteInformacoes;
import br.com.domain.model.cliente.ClienteRepository;
import br.com.domain.model.cliente.DadosAtualizacaoCliente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	@PostMapping
	public ResponseEntity cadastrarCliente(@RequestBody @Valid ClienteDadosCadastro dadosCadastro,
			UriComponentsBuilder uriBuilder) {
		
		Cliente cliente = clienteRepository.save(new Cliente(dadosCadastro));
		URI uri = uriBuilder.path("/api/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteInformacoes(cliente));
	}
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity deletarCliente(@PathVariable("id") Long id) {
		
		Cliente cliente = clienteRepository.getReferenceById(id);
		return ResponseEntity.noContent().build();
	}
	@Transactional
	@PutMapping
	public ResponseEntity atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente dadosCliente) {

		Cliente cliente = clienteRepository.getReferenceById(dadosCliente.getId());
		cliente.atualizarInformacoes(dadosCliente);
		return ResponseEntity.ok().body(new ClienteInformacoes(cliente));
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarClientePorId(@PathVariable("id") Long id) 
	{
		Cliente cliente = clienteRepository.getReferenceById(id);
		return ResponseEntity.ok().body(new ClienteInformacoes(cliente));
	}

}
