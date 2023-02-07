package br.com.domain.model.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {

	public ClienteNaoEncontradoException() {
		super("Cliente não encontrado");
	}
}
