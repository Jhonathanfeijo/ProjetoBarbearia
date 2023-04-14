package br.com.domain.model.cliente;

import java.time.LocalDate;

import br.com.domain.model.usuario.DadosAtualizacaoUsuario;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DadosAtualizacaoCliente {

	@NotNull
	private Long id;
	private LocalDate dataNascimento;
	private String cpf;
	private String nome;
	private DadosAtualizacaoUsuario dadosUsuario;
}
