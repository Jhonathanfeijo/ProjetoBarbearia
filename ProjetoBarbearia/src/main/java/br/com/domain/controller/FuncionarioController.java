package br.com.domain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.domain.model.entities.Funcionario;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
	
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		return null;
	}
	
	public void deletarFuncionario(Funcionario funcionario) {
		
	}
	
	public Funcionario buscarFuncionario(Funcionario funcionario) {
		return null;
	}
}
