package br.com.domain.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.domain.model.funcionario.Funcionario;
import br.com.domain.model.funcionario.FuncionarioDadosAtualizacao;
import br.com.domain.model.funcionario.FuncionarioDadosCadastro;
import br.com.domain.model.funcionario.FuncionarioInformacoes;
import br.com.domain.model.funcionario.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@PostMapping
	public ResponseEntity cadastrarFuncionario(@RequestBody FuncionarioDadosCadastro dadosFuncionario,
			UriComponentsBuilder uriBuilder) {

		Funcionario funcionario = funcionarioRepository.save(new Funcionario(dadosFuncionario));
		URI uri = uriBuilder.path("/api/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();

		return ResponseEntity.created(uri).body(new FuncionarioInformacoes(funcionario));
	}

	@PutMapping
	public ResponseEntity atualizarFuncionario(@RequestBody FuncionarioDadosAtualizacao dadosFuncionario) {

		Funcionario funcionario = funcionarioRepository.getReferenceById(dadosFuncionario.getId());
		funcionario.atualizar(dadosFuncionario);
		return ResponseEntity.ok().body(new FuncionarioInformacoes(funcionario));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluirFuncionario(@PathVariable("id") Long id) {
		Funcionario funcionario = funcionarioRepository.getReferenceById(id);
		funcionario.desativar();
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarFuncionario(@PathVariable("id") Long id) {
		Funcionario funcionario = funcionarioRepository.getReferenceById(id);
		return ResponseEntity.ok().body(new FuncionarioInformacoes(funcionario));
	}
}
