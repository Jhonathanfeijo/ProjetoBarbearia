package br.com.domain.model.atendimento;

import java.time.LocalDateTime;
import java.util.List;

import br.com.domain.model.atendimento.item.ItemAtendimentoAgendamento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AtendimentoDadosAgendamento {
	@NotNull
	private Long idCliente;
	@NotNull
	private Long idFuncionario;
	@Valid
	private List<ItemAtendimentoAgendamento> itens;
	@NotNull
	@Future
	private LocalDateTime horario;

}
