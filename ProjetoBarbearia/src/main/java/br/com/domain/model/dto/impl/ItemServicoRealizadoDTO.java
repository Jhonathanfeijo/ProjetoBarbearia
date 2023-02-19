package br.com.domain.model.dto.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.domain.model.dto.request.ItemServicoRealizadoRequest;
import br.com.domain.model.dto.response.ItemServicoRealizadoResponse;
import br.com.domain.model.entities.ItemServicoRealizado;
import br.com.domain.model.entities.Servico;
import br.com.domain.model.services.ServicoService;
@Component
public class ItemServicoRealizadoDTO {

	@Autowired
	private ServicoService servicoService;

	public List<ItemServicoRealizado> toItemServicoRealizadoList(
			List<ItemServicoRealizadoRequest> itemServicoRealizadoRequest) {
		List<ItemServicoRealizado> itens = itemServicoRealizadoRequest.stream().map(item -> {
			Servico servico = servicoService.buscarServicoPorId(item.getIdServico());
			Integer quantidadeServico = item.getQuantidade();
			return ItemServicoRealizado.builder().servico(servico).quantidade(quantidadeServico).build();
		}).collect(Collectors.toList());
		return itens;
	}

	public List<ItemServicoRealizadoResponse> toItemServicoRealizadoResponseList(
			List<ItemServicoRealizado> itemServicoRealizado) {
		return itemServicoRealizado.stream().map(item -> {
			ItemServicoRealizadoResponse itemServicoRealizadoResponse = new ItemServicoRealizadoResponse();
			itemServicoRealizadoResponse.setNomeServico(item.getServico().getNomeServico());
			itemServicoRealizadoResponse.setQuantidade(item.getQuantidade());
			itemServicoRealizadoResponse.setValorServico(item.getServico().getValorServico());
			return itemServicoRealizadoResponse;
		}).collect(Collectors.toList());
	}
}
