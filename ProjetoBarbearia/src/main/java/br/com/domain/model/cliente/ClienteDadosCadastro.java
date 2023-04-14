package br.com.domain.model.cliente;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.domain.model.usuario.DadosCadastroUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ClienteDadosCadastro {
	@NotBlank
	private String nome;

	@NotBlank
	private String cpf;

	@NotBlank
	private String rg;

	@NotNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;

	@NotNull
	@Valid
	private DadosCadastroUsuario dadosUsuario;
}
