package br.com.domain.model.atendimento.validacao.agendamento;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import br.com.domain.model.atendimento.AtendimentoDadosAgendamento;

@Component
public class ValidacaoHorarioAgendamento implements ValidacaoAgendamento {

	@Override
	public void validar(AtendimentoDadosAgendamento dados) {
		boolean agendamentoDomingo = dados.getHorario().getDayOfWeek().equals(DayOfWeek.SUNDAY);
		boolean agendamentoAntesDeAbrir = dados.getHorario().getHour() < 8;
		boolean agendamentoDepoisDeFechar = dados.getHorario().getHour() > 17;
		if (agendamentoAntesDeAbrir || agendamentoDepoisDeFechar || agendamentoDomingo)
			throw new RuntimeException("Horário inválido para atendimento");
	}

}
