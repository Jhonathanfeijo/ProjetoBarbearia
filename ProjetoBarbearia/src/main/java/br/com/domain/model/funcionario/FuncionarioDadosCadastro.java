package br.com.domain.model.funcionario;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.domain.model.usuario.DadosCadastroUsuario;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
@Getter
public class FuncionarioDadosCadastro {

	private String nome;
	private String cpf;
	private String rg;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;
	private DadosCadastroUsuario dadosUsuario;
}
