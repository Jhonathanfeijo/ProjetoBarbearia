package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.dto.impl.ClienteDTO;
import br.com.domain.model.dto.response.ClienteResponse;
import br.com.domain.model.entities.Cliente;
import br.com.domain.model.exceptions.ClienteNaoEncontradoException;
import br.com.domain.model.repositories.ClienteRepository;
import br.com.domain.model.services.ClienteService;
import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteDTO clienteDTO;

	@Transactional
	@Override
	public ClienteResponse salvarCliente(Cliente cliente) {
		cliente = clienteRepository.save(cliente);
		return toClienteResponse(cliente);
	}

	@Transactional
	@Override
	public void deletarClientePorId(Integer id) {
		buscarClientePorId(id);
		clienteRepository.deleteById(id);
	}
	@Transactional
	@Override
	public ClienteResponse atualizarCliente(Cliente cliente, Integer id) {
		Cliente clienteEncontrado = buscarClientePorId(id);
		cliente.setId(clienteEncontrado.getId());
		cliente = clienteRepository.save(cliente);
		return toClienteResponse(cliente);
	}

	@Override
	public Cliente buscarClientePorId(Integer id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException());
	}

	@Override
	public ClienteResponse obterClienteResponse(Integer id) {
		Cliente cliente = buscarClientePorId(id);
		return toClienteResponse(cliente);
	}

	public ClienteResponse toClienteResponse(Cliente cliente) {
		return clienteDTO.toClienteResponse(cliente);
	}

}
