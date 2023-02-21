package br.com.domain.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import br.com.domain.model.dto.impl.ServicoRealizadoDTO;
import br.com.domain.model.dto.request.ServicoRealizadoRequest;
import br.com.domain.model.dto.response.ServicoRealizadoResponse;
import br.com.domain.model.entities.ItemServicoRealizado;
import br.com.domain.model.entities.ServicoRealizado;
import br.com.domain.model.exceptions.ServicoRealizadoNaoEncontradoException;
import br.com.domain.model.repositories.ServicoRealizadoRepository;
import br.com.domain.model.services.ItemServicoRealizadoService;
import br.com.domain.model.services.ServicoRealizadoService;
import jakarta.transaction.Transactional;

@Service
public class ServicoRealizadoServiceImpl implements ServicoRealizadoService {

	@Autowired
	private ServicoRealizadoRepository servicoRealizadoRepository;

	@Autowired
	private ServicoRealizadoDTO servicoRealizadoDTO;

	@Autowired
	private ItemServicoRealizadoService itemServicoRealizadoService;

	@Transactional
	@Override
	public ServicoRealizadoResponse salvarServicoRealizado(ServicoRealizadoRequest servicoRealizadoRequest) {
		ServicoRealizado servicoRealizado = toServicoRealizado(servicoRealizadoRequest);
		servicoRealizado = servicoRealizadoRepository.save(servicoRealizado);
		return toServicoRealizadoResponse(servicoRealizado);
	}

	@Modifying
	@Transactional
	@Override
	public ServicoRealizadoResponse atualizarServicoRealizado(ServicoRealizadoRequest servicoRealizadoRequest,
			Integer id) {
		buscarServicoRealizadoPorId(id);
		ServicoRealizado servicoRealizado = toServicoRealizado(servicoRealizadoRequest);
		List<ItemServicoRealizado> itensAtualizados = itemServicoRealizadoService
				.atualizarItemServicoRealizadoList(servicoRealizado.getItens(), id);
		servicoRealizado.setId(id);
		servicoRealizado.setItens(itensAtualizados);
		servicoRealizado = servicoRealizadoRepository.save(servicoRealizado);
		return toServicoRealizadoResponse(servicoRealizado);
	}

	@Transactional
	@Override
	public void deletarServicoRealizadoPorId(Integer id) {
		ServicoRealizado servicoRealizadoEncontrado = buscarServicoRealizadoPorId(id);
		servicoRealizadoRepository.deleteById(servicoRealizadoEncontrado.getId());
	}

	@Override
	public ServicoRealizado buscarServicoRealizadoPorId(Integer id) {
		return servicoRealizadoRepository.findById(id).orElseThrow(() -> new ServicoRealizadoNaoEncontradoException());
	}

	@Override
	public ServicoRealizadoResponse obterServicoRealizadoResponse(Integer id) {
		ServicoRealizado servicoRealizado = buscarServicoRealizadoPorId(id);
		return toServicoRealizadoResponse(servicoRealizado);
	}

	public ServicoRealizadoResponse toServicoRealizadoResponse(ServicoRealizado servicoRealizado) {
		return servicoRealizadoDTO.toServicoRealizadoResponse(servicoRealizado);
	}

	public ServicoRealizado toServicoRealizado(ServicoRealizadoRequest servicoRealizadoRequest) {
		return servicoRealizadoDTO.toServicoRealizado(servicoRealizadoRequest);
	}

}
