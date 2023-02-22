package br.com.domain.model.dto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.domain.model.dto.response.ClienteResponse;
import br.com.domain.model.dto.response.DadosPessoaisResponse;
import br.com.domain.model.entities.Cliente;
import br.com.domain.model.entities.ServicoRealizado;
import br.com.domain.model.services.ServicoRealizadoService;

@Component
public class ClienteDTO {

	@Autowired
	private DadosPessoaisDTO dadosPessoasDTO;

	@Autowired
	@Lazy
	private ServicoRealizadoService servicoRealizadoService;

	public ClienteResponse toClienteResponse(Cliente cliente) {
		DadosPessoaisResponse dadosPessoaisResponse = dadosPessoasDTO
				.toDadosPessoaisResponse(cliente.getDadosPessoais());

		Integer quantidadeServicosRealizados;
		List<ServicoRealizado> servicosRealizadosPorCliente = servicoRealizadoService
				.buscarServicosRealizadosPorClienteId(cliente.getId());
		if(servicosRealizadosPorCliente == null)
			quantidadeServicosRealizados = 0;
		quantidadeServicosRealizados = servicosRealizadosPorCliente.size();
		return ClienteResponse.builder().dadosPessoais(dadosPessoaisResponse)
				.quantidadeServicosRealizados(quantidadeServicosRealizados).build();
	}
}
