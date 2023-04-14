package br.com.domain.model.atendimento.validacao.agendamento;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.domain.model.atendimento.AtendimentoDadosAgendamento;
import br.com.domain.model.atendimento.AtendimentoRepository;

@Component
public class ValidacaoHorarioDisponivelComFuncionario implements ValidacaoAgendamento {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Override
	public void validar(AtendimentoDadosAgendamento dados) {
		boolean horarioEstaOcupado = atendimentoRepository.existsByFuncionarioIdAndHorarioMarcado( dados.getIdFuncionario(),  dados.getHorario());
		if(horarioEstaOcupado)
			throw new RuntimeException("Funcionário já tem atendimento para esse horário");
	}
}
