package br.com.domain.model.funcionario;

import java.time.LocalDate;

import br.com.domain.model.usuario.DadosAtualizacaoUsuario;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class FuncionarioDadosAtualizacao {

	@NotNull
	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;
	private DadosAtualizacaoUsuario dadosUsuario;
}
