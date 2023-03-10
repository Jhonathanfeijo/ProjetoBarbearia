package br.com.domain.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.domain.model.dto.impl.FuncionarioDTO;
import br.com.domain.model.dto.response.FuncionarioResponse;
import br.com.domain.model.entities.Funcionario;
import br.com.domain.model.services.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private FuncionarioDTO funcionarioDTO;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FuncionarioResponse salvarFuncionario(@RequestBody Funcionario funcionario) {
		funcionario = funcionarioService.salvarFuncionario(funcionario);
		return funcionarioDTO.toFuncionarioResponse(funcionario);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public FuncionarioResponse atualizarFuncionario(@RequestBody Funcionario funcionario,
			@PathVariable("id") Integer id) {
		funcionario = funcionarioService.atualizarFuncionarioPorId(funcionario, id);
		return funcionarioDTO.toFuncionarioResponse(funcionario);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarFuncionario(@PathVariable("id") Integer id) {
		funcionarioService.excluirFuncionarioPorId(id);
	}

	@GetMapping("/{id}")
	public FuncionarioResponse buscarFuncionario(@PathVariable("id") Integer id) {
		Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
		return funcionarioDTO.toFuncionarioResponse(funcionario);
	}
}
