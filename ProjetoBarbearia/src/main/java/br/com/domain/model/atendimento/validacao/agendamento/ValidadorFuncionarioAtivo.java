package br.com.domain.model.atendimento.validacao.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.domain.model.atendimento.AtendimentoDadosAgendamento;
import br.com.domain.model.funcionario.Funcionario;
import br.com.domain.model.funcionario.FuncionarioRepository;
@Component
public class ValidadorFuncionarioAtivo implements ValidacaoAgendamento {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public void validar(AtendimentoDadosAgendamento dados) {
		Funcionario funcionario = funcionarioRepository.getReferenceById(dados.getIdFuncionario());
		if(!funcionario.isAtivo())
			throw new RuntimeException("Funcionario não está ativo");
	}


}
