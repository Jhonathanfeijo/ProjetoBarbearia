package br.com.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.domain.model.entities.Funcionario;
import br.com.domain.model.services.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioService.salvarFuncionario(funcionario);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarFuncionario(@PathVariable("id") Integer id) {
		funcionarioService.excluirFuncionarioPorId(id);
	}

	@GetMapping("/{id}")
	public Funcionario buscarFuncionario(@PathVariable("id") Integer id) {
		return funcionarioService.buscarFuncionarioPorId(id);
	}
}
