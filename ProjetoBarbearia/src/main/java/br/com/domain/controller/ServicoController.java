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

import br.com.domain.model.Servico.Servico;
import br.com.domain.model.Servico.ServicoDadosAtualizacao;
import br.com.domain.model.Servico.ServicoDadosCadastro;
import br.com.domain.model.Servico.ServicoInformacoes;
import br.com.domain.model.Servico.ServicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	private ServicoRepository servicoRepository;

	@Transactional
	@PostMapping
	public ResponseEntity cadastrarServico(@RequestBody @Valid ServicoDadosCadastro dados,
			UriComponentsBuilder uriBuilder) {

		Servico servico = servicoRepository.save(new Servico(dados));
		URI uri = uriBuilder.path("api/servico").buildAndExpand(servico.getId()).toUri();
		return ResponseEntity.created(uri).body(new ServicoInformacoes(servico));
	}

	@Transactional
	@PutMapping
	public ResponseEntity atualizarServico(@RequestBody ServicoDadosAtualizacao dadosServico) {

		Servico servico = servicoRepository.getReferenceById(dadosServico.getId());
		servico.atualizar(dadosServico);
		return ResponseEntity.ok().body(new ServicoInformacoes(servico));
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarServico(@PathVariable("id") Long id) {

		Servico servico = servicoRepository.getReferenceById(id);
		return ResponseEntity.ok().body(new ServicoInformacoes(servico));
	}

	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity deletarServico(@PathVariable("id") Long id) {

		Servico servico = servicoRepository.getReferenceById(id);
		servico.desativar();
		return ResponseEntity.noContent().build();
	}

}
