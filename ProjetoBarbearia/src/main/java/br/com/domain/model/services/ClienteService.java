package br.com.domain.model.services;

import br.com.domain.model.entities.Cliente;

public interface ClienteService {

	public Cliente salvarCliente (Cliente cliente);
		
	public void deletarClientePorId (Integer id);
	
	public Cliente atualizarCliente(Cliente cliente, Integer id);
	
	public Cliente buscarClientePorId (Integer id);
	
}
