package br.com.domain.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.domain.model.funcionario.Funcionario;
import br.com.domain.model.funcionario.FuncionarioDadosAtualizacao;
import br.com.domain.model.funcionario.FuncionarioDadosCadastro;
import br.com.domain.model.funcionario.FuncionarioInformacoes;
import br.com.domain.model.funcionario.FuncionarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Transactional
	@PostMapping
	public ResponseEntity cadastrarFuncionario(@RequestBody @Valid FuncionarioDadosCadastro dadosFuncionario,
			UriComponentsBuilder uriBuilder) {

		Funcionario funcionario = funcionarioRepository.save(new Funcionario(dadosFuncionario));
		URI uri = uriBuilder.path("/api/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();

		return ResponseEntity.created(uri).body(new FuncionarioInformacoes(funcionario));
	}
	@Transactional
	@PutMapping
	public ResponseEntity atualizarFuncionario(@RequestBody  @Valid FuncionarioDadosAtualizacao dadosFuncionario) {

		Funcionario funcionario = funcionarioRepository.getReferenceById(dadosFuncionario.getId());
		funcionario.atualizar(dadosFuncionario);
		return ResponseEntity.ok().body(new FuncionarioInformacoes(funcionario));
	}
	@Transactional
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
