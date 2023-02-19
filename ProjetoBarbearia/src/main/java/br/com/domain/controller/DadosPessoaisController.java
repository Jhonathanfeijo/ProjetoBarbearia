package br.com.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.domain.model.entities.DadosPessoais;
import br.com.domain.model.exceptions.DadosPessoaisNaoEncontradoException;
import br.com.domain.model.repositories.DadosPessoaisRepository;

@RestController
@RequestMapping("/api/dados")
public class DadosPessoaisController {
	
	@Autowired
	private DadosPessoaisRepository dadosPessoaisRepository;
	@GetMapping("/{id}")
	public DadosPessoais dadosPessoaisPorId(@PathVariable("id")Integer id) {
		return dadosPessoaisRepository.findById(id).orElseThrow(() -> new DadosPessoaisNaoEncontradoException());
	}

}
