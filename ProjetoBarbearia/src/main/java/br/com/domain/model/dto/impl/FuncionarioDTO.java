package br.com.domain.model.dto.impl;

import org.springframework.stereotype.Component;

import br.com.domain.model.dto.response.FuncionarioResponse;
import br.com.domain.model.entities.Funcionario;
@Component
public class FuncionarioDTO {

	public FuncionarioResponse toFuncionarioResponse(Funcionario funcionario) {
		FuncionarioResponse funcionarioResponse = new FuncionarioResponse();
		funcionarioResponse.setNomeFuncionario(funcionario.getDadosPessoais().getNome());
		funcionarioResponse.setCpf(funcionario.getDadosPessoais().getCpf());
		funcionarioResponse.setRg(funcionario.getDadosPessoais().getCpf());
		return funcionarioResponse;
	}
}
