package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.entities.ServicoRealizado;
import br.com.domain.model.exceptions.ServicoRealizadoNaoEncontradoException;
import br.com.domain.model.repositories.ServicoRealizadoRepository;
import br.com.domain.model.services.ServicoRealizadoService;

@Service
public class ServicoRealizadoServiceImpl implements ServicoRealizadoService {
	
	@Autowired
	private ServicoRealizadoRepository servicoRealizadoRepository;

	@Override
	public ServicoRealizado salvarServicoRealizado(ServicoRealizado servicoRealizado) {
		return servicoRealizado = servicoRealizadoRepository.save(servicoRealizado);
	}

	@Override
	public ServicoRealizado atualizarServicoRealizado(ServicoRealizado servicoRealizado, Integer id) {
		return servicoRealizadoRepository.findById(id).map(servicoRealizadoEncontrado ->{
			servicoRealizado.setId(id);
			servicoRealizadoRepository.save(servicoRealizado);
			return servicoRealizado;
		}).orElseThrow(() -> new ServicoRealizadoNaoEncontradoException());
	}

	@Override
	public void deletarServicoRealizadoPorId(Integer id) {
		servicoRealizadoRepository.findById(id).map(servicoRealizadoEncontrado ->{
			servicoRealizadoRepository.deleteById(id);
			return servicoRealizadoEncontrado;
		}).orElseThrow(() -> new ServicoRealizadoNaoEncontradoException());
	}

	@Override
	public ServicoRealizado buscarServicoRealizadoPorId(Integer id) {
		return servicoRealizadoRepository.findById(id).orElseThrow(() -> new ServicoRealizadoNaoEncontradoException());
	}

}
