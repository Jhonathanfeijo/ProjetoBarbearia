package br.com.domain.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {
	
	@Autowired
	private AgendaAtendimento agenda;
	
	@Transactional
	@PostMapping
	public ResponseEntity agendar(@RequestBody AtendimentoDadosAgendamento dados, UriComponentsBuilder builder) {
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
}
