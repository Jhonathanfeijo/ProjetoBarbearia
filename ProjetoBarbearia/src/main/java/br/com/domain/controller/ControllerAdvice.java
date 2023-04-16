package br.com.domain.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(RuntimeException.class)
	public String exceptionHandler(RuntimeException exception) {
		return exception.getMessage();
	}
}
