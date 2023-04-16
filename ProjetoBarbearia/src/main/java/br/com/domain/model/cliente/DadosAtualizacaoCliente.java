package br.com.domain.model.cliente;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.domain.model.usuario.DadosAtualizacaoUsuario;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DadosAtualizacaoCliente {

	@NotNull
	private Long id;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;
	private String nome;
	private DadosAtualizacaoUsuario dadosUsuario;
}
