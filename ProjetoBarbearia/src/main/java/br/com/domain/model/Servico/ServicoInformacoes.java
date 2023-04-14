package br.com.domain.model.Servico;

import java.math.BigDecimal;

import lombok.Getter;
@Getter
public class ServicoInformacoes {
	
	private String nome;
	private BigDecimal valor;
	private Integer duracaoMinutos;

	public ServicoInformacoes(Servico servico) {
		this.nome = servico.getNomeServico();
		this.valor = servico.getValorServico();
		this.duracaoMinutos = servico.getDuracaoMinutos();
	}
}
