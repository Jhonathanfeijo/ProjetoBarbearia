package br.com.domain.model.exceptions;

public class ServicoNaoEncontradoException extends RuntimeException {

	public ServicoNaoEncontradoException() {
		super("Serviço não encontrado exception");
	}
}
