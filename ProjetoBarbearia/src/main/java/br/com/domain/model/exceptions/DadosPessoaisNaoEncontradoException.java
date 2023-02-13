package br.com.domain.model.exceptions;

public class DadosPessoaisNaoEncontradoException extends RuntimeException {

	public DadosPessoaisNaoEncontradoException() {
		super("Dados pessoais não foram encontrados");
	}
}
