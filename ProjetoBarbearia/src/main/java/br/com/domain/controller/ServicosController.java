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

import br.com.domain.model.entities.Servico;
import br.com.domain.model.services.ServicoService;

@RestController
@RequestMapping("/api/servico")
public class ServicosController {
	
	@Autowired
	private ServicoService servicoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico salvarServico(@RequestBody Servico servico) {
		return servicoService.salvarServico(servico);
	}
	
	@GetMapping("/{id}")
	public Servico buscarServico(@PathVariable("id")Integer id) {
		return servicoService.buscarServicoPorId(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Servico AtualizarServico (@PathVariable("id") Integer id, @RequestBody Servico servico) {
		return servicoService.atualizarServico(servico, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarServico(@PathVariable("id") Integer id) {
		servicoService.deletarServico(id);
	}

}
