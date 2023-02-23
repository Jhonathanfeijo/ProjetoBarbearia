package br.com.domain.model.dto.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.domain.model.dto.response.ServicoResponse;
import br.com.domain.model.entities.Servico;

@Component
public class ServicoDTO {

	public ServicoResponse toServicoResponse(Servico servico) {
		BigDecimal valorServico = servico.getValorServico();
		Integer duracaoMinutosServico = servico.getDuracaoMinutos();
		String nomeServico = servico.getNomeServico();
		return ServicoResponse.builder().duracaoMinutosServico(duracaoMinutosServico).nomeServico(nomeServico)
				.valorServico(valorServico).build();
	}
}
