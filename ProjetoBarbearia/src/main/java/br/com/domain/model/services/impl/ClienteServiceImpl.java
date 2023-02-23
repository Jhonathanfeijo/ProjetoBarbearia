package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.entities.Cliente;
import br.com.domain.model.entities.DadosPessoais;
import br.com.domain.model.entities.Usuario;
import br.com.domain.model.exceptions.ClienteNaoEncontradoException;
import br.com.domain.model.repositories.ClienteRepository;
import br.com.domain.model.services.ClienteService;
import br.com.domain.model.services.DadosPessoaisService;
import br.com.domain.model.services.UsuarioService;
import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private DadosPessoaisService dadosPessoaisService;

	@Autowired
	private UsuarioService usuarioService;
	
	// Salvar cliente
	@Transactional
	@Override
	public Cliente salvarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	//Deletar cliente por id
	@Transactional
	@Override
	public void deletarClientePorId(Integer id) {
		buscarClientePorId(id);
		clienteRepository.deleteById(id);
	}
	// Atualizar cliente por id
	@Transactional
	@Override
	public Cliente atualizarCliente(Cliente cliente, Integer id) {
		Cliente clienteEncontrado = buscarClientePorId(id);
		DadosPessoais dadosPessoais = dadosPessoaisService.atualizarDadosPessoais(clienteEncontrado.getDadosPessoais(),
				cliente.getDadosPessoais());
		Usuario usuario = usuarioService.atualizarUsuario(clienteEncontrado.getUsuario(), cliente.getUsuario());
		cliente.setDadosPessoais(dadosPessoais);
		cliente.setId(clienteEncontrado.getId());
		cliente.setUsuario(usuario);
		return salvarCliente(clienteEncontrado);
	}
	
	//Buscar cliente por id
	@Override
	public Cliente buscarClientePorId(Integer id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException());
	}
	

}
