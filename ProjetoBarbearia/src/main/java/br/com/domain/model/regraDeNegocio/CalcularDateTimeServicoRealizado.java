package br.com.domain.model.regraDeNegocio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.domain.model.entities.ItemServicoRealizado;

@Component
public class CalcularDateTimeServicoRealizado {

	//Calcula a hora que o ServicoRealizado foi concluido
	public LocalDateTime calcularConclusao(List<ItemServicoRealizado> itens, LocalDateTime horaServicoRealizado) {
		LocalDateTime horaConclusao = horaServicoRealizado;
		for (ItemServicoRealizado item : itens) {
			Integer duracaoItem = item.getQuantidade() * item.getServico().getDuracaoMinutos();
			horaConclusao = horaConclusao.plusMinutes(duracaoItem);
			}
		return horaConclusao;
	}
}
