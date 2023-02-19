package br.com.domain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.domain.model.exceptions.ClienteNaoEncontradoException;
import br.com.domain.model.exceptions.DadosPessoaisNaoEncontradoException;
import br.com.domain.model.exceptions.FuncionarioNaoEncontradoException;
import br.com.domain.model.exceptions.ServicoNaoEncontradoException;
import br.com.domain.model.exceptions.ServicoRealizadoNaoEncontradoException;
import br.com.domain.model.exceptions.UsuarioNaoEncontradoException;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(ServicoNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleServicoNaoEncontradoException(ServicoNaoEncontradoException ex) {
		return ex.getMessage();
	}
	@ExceptionHandler(ServicoRealizadoNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleServicoRealizadoNaoEncontradoException(ServicoRealizadoNaoEncontradoException ex) {
		return ex.getMessage();
	}
	@ExceptionHandler(ClienteNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleClienteNaoEncontradoException(ClienteNaoEncontradoException ex) {
		return ex.getMessage();
	}
	@ExceptionHandler(FuncionarioNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleClienteNaoEncontradoException(FuncionarioNaoEncontradoException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException ex) {
		return ex.getMessage();
	}
	@ExceptionHandler(DadosPessoaisNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleDadosPessoaisNaoEncontradoException(DadosPessoaisNaoEncontradoException ex) {
		return ex.getMessage();
	}
}
