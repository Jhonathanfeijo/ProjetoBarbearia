package br.com.domain.model.cliente;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class ClienteInformacoes {

	private String nome;
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;

	public ClienteInformacoes(Cliente cliente) {
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.rg = cliente.getRg();
		this.dataNascimento = cliente.getDataNascimento();
	}
}
