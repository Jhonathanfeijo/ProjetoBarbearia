package br.com.domain.model.atendimento;

import java.math.BigDecimal;
import java.util.List;

import br.com.domain.model.atendimento.item.ItemAtendimento;
import br.com.domain.model.atendimento.item.ItemAtendimentoInfo;
import lombok.Getter;

@Getter
public class AtendimentoInfo {

	private Long idCliente;
	private Long idFuncionario;
	private String nomeCliente;
	private String nomeFuncionario;
	private List<ItemAtendimentoInfo> itens;
	private BigDecimal valorTotal;

	public AtendimentoInfo(Atendimento atendimento) {
		this.idCliente = atendimento.getCliente().getId();
		this.nomeCliente = atendimento.getCliente().getNome();
		this.idFuncionario = atendimento.getFuncionario().getId();
		this.nomeFuncionario = atendimento.getFuncionario().getNome();
		this.valorTotal = atendimento.getValorAtendimento();
		this.itens = listarItens(atendimento.getItens());
	}

	private List<ItemAtendimentoInfo> listarItens(List<ItemAtendimento> itens) {
		return itens.stream().map(item -> {
			return new ItemAtendimentoInfo(item);
		}).toList();
	}
}
