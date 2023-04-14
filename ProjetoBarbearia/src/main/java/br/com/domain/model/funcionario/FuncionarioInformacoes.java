package br.com.domain.model.funcionario;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class FuncionarioInformacoes {
	private String nome;
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;

	public FuncionarioInformacoes(Funcionario funcionario) {
		
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.rg = funcionario.getRg();
		this.dataNascimento = funcionario.getDataNascimento();
		
	}
}
