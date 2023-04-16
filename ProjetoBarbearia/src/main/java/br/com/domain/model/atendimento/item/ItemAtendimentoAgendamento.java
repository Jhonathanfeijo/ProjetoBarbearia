package br.com.domain.model.atendimento.item;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ItemAtendimentoAgendamento {
	@NotNull
	private Long idServico;
	@NotNull
	private Integer quantidade;
}
