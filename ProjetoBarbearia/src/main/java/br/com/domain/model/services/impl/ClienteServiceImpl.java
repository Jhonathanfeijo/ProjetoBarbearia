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
	private UsuarioService usuarioService;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private DadosPessoaisService dadosPessoaisService;
	@Transactional
	@Override
	public Cliente salvarCliente(Cliente cliente) {
		Usuario usuario = usuarioService.salvarUsuario(cliente.getUsuario());
		DadosPessoais dadosPessoais = dadosPessoaisService.salvarDadosPessoais(cliente.getDadosPessoais());
		cliente.setDadosPessoais(dadosPessoais);
		cliente.setUsuario(usuario);
		return clienteRepository.save(cliente);
	}
	@Transactional
	@Override
	public void deletarClientePorId(Integer id) {
		Cliente clienteEncontrado = buscarClientePorId(id);
		Integer idUsuario = clienteEncontrado.getUsuario().getId();
		usuarioService.excluirUsuario(idUsuario);
		Integer idDadosPessoais = clienteEncontrado.getDadosPessoais().getId();
		dadosPessoaisService.excluirDadosPessoais(idDadosPessoais);
		clienteRepository.deleteById(id);
	}

	@Override
	public Cliente buscarClientePorId(Integer id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException());
	}

}
