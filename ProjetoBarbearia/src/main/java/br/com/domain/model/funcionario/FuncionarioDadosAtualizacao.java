package br.com.domain.model.funcionario;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.domain.model.usuario.UsuarioDadosAtualizacao;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class FuncionarioDadosAtualizacao {

	@NotNull
	private Long id;
	private String nome;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;
	private UsuarioDadosAtualizacao dadosUsuario;
}
