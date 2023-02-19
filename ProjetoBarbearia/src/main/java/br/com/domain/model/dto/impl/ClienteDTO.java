package br.com.domain.model.dto.impl;

import org.springframework.stereotype.Component;

import br.com.domain.model.dto.response.ClienteResponse;
import br.com.domain.model.entities.Cliente;
@Component
public class ClienteDTO {

	public ClienteResponse toClienteResponse(Cliente cliente) {
		ClienteResponse clienteResponse = new ClienteResponse();
		clienteResponse.setNomeCliente(cliente.getDadosPessoais().getNome());
		clienteResponse.setCpf(cliente.getDadosPessoais().getCpf());
		clienteResponse.setRg(cliente.getDadosPessoais().getRg());
		return clienteResponse;
	}
}
