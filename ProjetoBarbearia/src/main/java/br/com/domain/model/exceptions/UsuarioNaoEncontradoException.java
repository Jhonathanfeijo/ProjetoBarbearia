package br.com.domain.model.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
	
	public UsuarioNaoEncontradoException() {
		super("Usuário não encontrado");
	}

}
