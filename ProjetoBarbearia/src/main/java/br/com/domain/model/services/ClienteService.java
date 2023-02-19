package br.com.domain.model.services;

import br.com.domain.model.dto.response.ClienteResponse;
import br.com.domain.model.entities.Cliente;

public interface ClienteService {

	public ClienteResponse salvarCliente (Cliente cliente);
		
	public void deletarClientePorId (Integer id);
	
	public ClienteResponse atualizarCliente(Cliente cliente, Integer id);
	
	public Cliente buscarClientePorId (Integer id);
	
	public ClienteResponse obterClienteResponse(Integer id);
}
