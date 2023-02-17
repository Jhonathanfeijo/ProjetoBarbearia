package br.com.domain.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.dto.request.ServicoRealizadoRequest;
import br.com.domain.model.dto.request.impl.ServicoRealizadoMapper;
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
	private ItemServicoRealizadoService itemServicoRealizadoService;

	private ServicoRealizadoMapper servicoRealizadoMapper;

	@Transactional
	@Override
	public ServicoRealizadoResponse salvarServicoRealizado(ServicoRealizadoRequest servicoRealizadoRequest) {

		ServicoRealizado servicoRealizado = servicoRealizadoMapper.toServicoRealizado(servicoRealizadoRequest);
		servicoRealizado = servicoRealizadoRepository.save(servicoRealizado);
		List<ItemServicoRealizado> itensServicoRealizado = servicoRealizado.getItens();
		itensServicoRealizado = itemServicoRealizadoService.salvarItensServicoRealizado(itensServicoRealizado);
		return servicoRealizadoMapper.toServicoRealizadoResponse(servicoRealizado);
	}

	@Transactional
	@Override
	public ServicoRealizadoResponse atualizarServicoRealizado(ServicoRealizadoRequest servicoRealizadoRequest,
			Integer id) {
		ServicoRealizado servicoRealizadoEncontrado = buscarServicoRealizadoPorId(id);
		ServicoRealizado servicoRealizado = servicoRealizadoMapper.toServicoRealizado(servicoRealizadoRequest);
		servicoRealizado.setId(servicoRealizadoEncontrado.getId());
		return servicoRealizadoMapper.toServicoRealizadoResponse(servicoRealizado);
	}

	@Override
	public void deletarServicoRealizadoPorId(Integer id) {
		ServicoRealizado servicoRealizadoEncontrado = buscarServicoRealizadoPorId(id);
		servicoRealizadoRepository.deleteById(servicoRealizadoEncontrado.getId());
	}

	@Override
	public ServicoRealizado buscarServicoRealizadoPorId(Integer id) {
		return servicoRealizadoRepository.findById(id).orElseThrow(() -> new ServicoRealizadoNaoEncontradoException());
	}

}
