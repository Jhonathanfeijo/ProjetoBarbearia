package br.com.domain.model.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.domain.model.dto.response.ClienteResponse;
import br.com.domain.model.dto.response.DadosPessoaisResponse;
import br.com.domain.model.entities.Cliente;
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
		Integer quantidadeServicosRealizados = servicoRealizadoService.obterQuantidadeServicosRealizadosPorClienteId(cliente.getId());
		return ClienteResponse.builder().dadosPessoais(dadosPessoaisResponse)
				.quantidadeServicosRealizados(quantidadeServicosRealizados).build();
	}
}
