package br.com.domain.model.atendimento.validacao.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.domain.model.atendimento.AtendimentoDadosAgendamento;
import br.com.domain.model.funcionario.FuncionarioRepository;

@Component
public class ValidacaoFuncionarioExiste implements ValidacaoAgendamento {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public void validar(AtendimentoDadosAgendamento dados) {
		boolean funcionarioExiste = funcionarioRepository.existsById(dados.getIdFuncionario());
		if(!funcionarioExiste)
			throw new RuntimeException("Funcionário não encontrado");
	}

}
