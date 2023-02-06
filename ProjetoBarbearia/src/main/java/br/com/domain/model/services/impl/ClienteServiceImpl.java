package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.domain.model.entities.Cliente;
import br.com.domain.model.entities.Usuario;
import br.com.domain.model.repositories.ClienteRepository;
import br.com.domain.model.services.ClienteService;
import br.com.domain.model.services.UsuarioService;

public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente salvarCliente(Cliente cliente) {
		Usuario usuario = usuarioService.salvarUsuario(cliente.getUsuario());
		cliente.setUsuario(usuario);
		return clienteRepository.save(cliente);
		
	}

	@Override
	public void deletarClientePorId(Integer id) {
		clienteRepository.findById(id).map(clienteEncontrado ->{
			Integer idUsuario = clienteEncontrado.getUsuario().getId();
			usuarioService.excluirUsuario(idUsuario);
			clienteRepository.deleteById(id);
			return null;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
	}

	@Override
	public Cliente buscarClientePorId(Integer id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
	}

}
