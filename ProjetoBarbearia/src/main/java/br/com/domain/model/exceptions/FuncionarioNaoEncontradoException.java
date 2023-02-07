package br.com.domain.model.exceptions;

public class FuncionarioNaoEncontradoException extends RuntimeException {

	public FuncionarioNaoEncontradoException() {
		super("Funcionário não encontrado");
	}
}
