package br.com.domain.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.domain.model.atendimento.AgendaAtendimento;
import br.com.domain.model.atendimento.Atendimento;
import br.com.domain.model.atendimento.AtendimentoDadosAgendamento;
import br.com.domain.model.atendimento.AtendimentoInfo;
import br.com.domain.model.atendimento.AtendimentoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

	@Autowired
	private AgendaAtendimento agenda;

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Transactional
	@PostMapping
	public ResponseEntity agendar(@RequestBody @Valid  AtendimentoDadosAgendamento dados, UriComponentsBuilder builder) {
		Atendimento atendimento = agenda.agendar(dados);
		URI uri = builder.path("/atendimento/{id}").buildAndExpand(atendimento.getId()).toUri();
		return ResponseEntity.created(uri).body(new AtendimentoInfo(atendimento));
	}

	@Transactional
	@PatchMapping("/{id}")
	public ResponseEntity cancelar(@PathVariable("id") Long id) {
		agenda.cancelar(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity obterInfoConsulta(@PathVariable("id") Long id) {
		Atendimento atendimento = atendimentoRepository.getReferenceById(id);
		return ResponseEntity.ok(new AtendimentoInfo(atendimento));
	}
}
