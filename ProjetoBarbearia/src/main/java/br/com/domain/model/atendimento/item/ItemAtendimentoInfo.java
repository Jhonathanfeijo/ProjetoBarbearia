package br.com.domain.model.atendimento.item;

import java.math.BigDecimal;

import lombok.Getter;
@Getter
public class ItemAtendimentoInfo {

	private String nomeServico;
	private Integer quantidade;
	private BigDecimal valorServico;
	
	public ItemAtendimentoInfo(ItemAtendimento item) {
		this.nomeServico = item.getServico().getNomeServico();
		this.quantidade = item.getQuantidade();
		this.valorServico = item.getServico().getValorServico();
	}
}
