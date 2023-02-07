package br.com.domain.model.exceptions;

public class ServicoRealizadoNaoEncontradoException extends RuntimeException {

	public ServicoRealizadoNaoEncontradoException() {
		super("Serviço realizado não encontrado");
	}
}
