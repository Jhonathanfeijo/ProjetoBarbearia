package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.entities.Servico;
import br.com.domain.model.exceptions.ServicoNaoEncontradoException;
import br.com.domain.model.repositories.ServicoRepository;
import br.com.domain.model.services.ServicoService;
import jakarta.transaction.Transactional;

@Service
public class ServicoServiceImpl implements ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	@Transactional
	@Override
	public Servico salvarServico(Servico servico) {
		return servicoRepository.save(servico);
	}

	@Transactional
	@Override
	public void deletarServico(Integer id) {
		servicoRepository.findById(id).map(servicoEncontrado -> {
			servicoRepository.deleteById(id);
			return servicoEncontrado;
		}).orElseThrow(() -> new ServicoNaoEncontradoException());
	}

	@Transactional
	@Override
	public Servico atualizarServico(Servico servico, Integer id) {
		Servico servicoAtualizado = servicoRepository.findById(id).map(servicoEncontrado -> {
			servico.setId(id);
			servicoRepository.save(servico);
			return servico;
		}).orElseThrow(() -> new ServicoNaoEncontradoException());
		return servicoAtualizado;
	}

	@Override
	public Servico buscarServicoPorId(Integer id) {
		return servicoRepository.findById(id).orElseThrow(() -> new ServicoNaoEncontradoException());
	}

}
