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

import br.com.domain.model.dto.impl.ServicoDTO;
import br.com.domain.model.dto.response.ServicoResponse;
import br.com.domain.model.entities.Servico;
import br.com.domain.model.services.ServicoService;

@RestController
@RequestMapping("/api/servico")
public class ServicosController {

	@Autowired
	private ServicoService servicoService;

	@Autowired
	private ServicoDTO servicoDTO;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoResponse salvarServico(@RequestBody Servico servico) {
		servico = servicoService.salvarServico(servico);
		return servicoDTO.toServicoResponse(servico);
	}

	@GetMapping("/{id}")
	public ServicoResponse buscarServico(@PathVariable("id") Integer id) {
		Servico servico = servicoService.buscarServicoPorId(id);
		return servicoDTO.toServicoResponse(servico);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ServicoResponse AtualizarServico(@PathVariable("id") Integer id, @RequestBody Servico servico) {
		servico = servicoService.atualizarServico(servico, id);
		return servicoDTO.toServicoResponse(servico);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarServico(@PathVariable("id") Integer id) {
		servicoService.deletarServico(id);
	}

}
