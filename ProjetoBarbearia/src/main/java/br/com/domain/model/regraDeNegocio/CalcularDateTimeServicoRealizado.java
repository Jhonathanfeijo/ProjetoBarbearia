package br.com.domain.model.regraDeNegocio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.domain.model.entities.ItemServicoRealizado;

@Component
public class CalcularDateTimeServicoRealizado {

	public LocalDateTime calcularConclusao(List<ItemServicoRealizado> itens, LocalDateTime horaServicoRealizado) {
		LocalDateTime horaConclusao = LocalDateTime.from(horaServicoRealizado);
		for (ItemServicoRealizado item : itens)
			horaConclusao = horaConclusao.plusMinutes(item.getServico().getDuracaoMinutos());
		return horaConclusao;
	}
}
