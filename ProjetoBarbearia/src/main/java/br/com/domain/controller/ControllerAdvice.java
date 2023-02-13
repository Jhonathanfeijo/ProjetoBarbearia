package br.com.domain.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.domain.model.exceptions.ClienteNaoEncontradoException;
import br.com.domain.model.exceptions.FuncionarioNaoEncontradoException;
import br.com.domain.model.exceptions.ServicoNaoEncontradoException;
import br.com.domain.model.exceptions.ServicoRealizadoNaoEncontradoException;
import br.com.domain.model.exceptions.UsuarioNaoEncontradoException;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(ServicoNaoEncontradoException.class)
	public String handleServicoNaoEncontradoException(ServicoNaoEncontradoException ex) {
		return ex.getMessage();
	}
	@ExceptionHandler(ServicoRealizadoNaoEncontradoException.class)
	public String handleServicoRealizadoNaoEncontradoException(ServicoRealizadoNaoEncontradoException ex) {
		return ex.getMessage();
	}
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public String handleClienteNaoEncontradoException(ClienteNaoEncontradoException ex) {
		return ex.getMessage();
	}
	@ExceptionHandler(FuncionarioNaoEncontradoException.class)
	public String handleClienteNaoEncontradoException(FuncionarioNaoEncontradoException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public String handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException ex) {
		return ex.getMessage();
	}
}
