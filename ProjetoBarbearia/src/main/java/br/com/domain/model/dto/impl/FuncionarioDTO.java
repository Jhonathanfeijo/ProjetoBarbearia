package br.com.domain.model.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.domain.model.dto.response.DadosPessoaisResponse;
import br.com.domain.model.dto.response.FuncionarioResponse;
import br.com.domain.model.entities.Funcionario;
@Component
public class FuncionarioDTO {

	@Autowired
	private DadosPessoaisDTO dadosPessoaisDTO;
	//Converter Funcionario para FuncionarioResponse
	public FuncionarioResponse toFuncionarioResponse(Funcionario funcionario) {
		DadosPessoaisResponse dadosPessoaisResponse = dadosPessoaisDTO.toDadosPessoaisResponse(funcionario.getDadosPessoais());
		return FuncionarioResponse.builder().dadosPessoais(dadosPessoaisResponse).build();
	}
}
