package br.com.domain.model.dto.impl;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import br.com.domain.model.dto.response.DadosPessoaisResponse;
import br.com.domain.model.entities.DadosPessoais;

@Component
public class DadosPessoaisDTO {
	//Converter DadosPessoais para DadosPessoaisResponse
	public DadosPessoaisResponse toDadosPessoaisResponse(DadosPessoais dados) {
		String nome = dados.getNome();
		String cpf = dados.getCpf();
		String rg = dados.getRg();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataNascimento = formatador.format(dados.getDataNascimento());
		return DadosPessoaisResponse.builder().cpf(cpf).dataNascimento(dataNascimento).rg(rg).nome(nome).build();
	}
}
