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

import br.com.domain.model.dto.impl.ServicoRealizadoDTO;
import br.com.domain.model.dto.request.ServicoRealizadoRequest;
import br.com.domain.model.dto.response.ServicoRealizadoResponse;
import br.com.domain.model.entities.ServicoRealizado;
import br.com.domain.model.services.ServicoRealizadoService;

@RestController
@RequestMapping("/api/servicorealizado")
public class ServicoRealizadoController {

	@Autowired
	private ServicoRealizadoService servicoRealizadoService;

	@Autowired
	private ServicoRealizadoDTO servicoRealizadoDTO;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoRealizadoResponse salvarServicoRealizado(
			@RequestBody ServicoRealizadoRequest servicoRealizadoRequest) {
		ServicoRealizado servicoRealizado = servicoRealizadoService.salvarServicoRealizado(servicoRealizadoRequest);
		return servicoRealizadoDTO.toServicoRealizadoResponse(servicoRealizado);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ServicoRealizadoResponse atualizarServicoRealizado(@PathVariable("id") Integer id,
			@RequestBody ServicoRealizadoRequest servicoRealizadoRequest) {
		ServicoRealizado servicoRealizado = servicoRealizadoService.atualizarServicoRealizado(servicoRealizadoRequest,
				id);
		return servicoRealizadoDTO.toServicoRealizadoResponse(servicoRealizado);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarServicoRealizado(@PathVariable("id") Integer id) {
		servicoRealizadoService.deletarServicoRealizadoPorId(id);
	}

	@GetMapping("/{id}")
	public ServicoRealizadoResponse buscarServico(@PathVariable("id") Integer id) {
		ServicoRealizado servicoRealizado = servicoRealizadoService.buscarServicoRealizadoPorId(id);
		return servicoRealizadoDTO.toServicoRealizadoResponse(servicoRealizado);
	}

}
