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
		Servico servico = buscarServicoPorId(id);
		servicoRepository.deleteById(servico.getId());
	}

	@Transactional
	@Override
	public Servico atualizarServico(Servico servico, Integer id) {
		Servico servicoEncontrado = buscarServicoPorId(id);
		servico.setId(servicoEncontrado.getId());
		return servicoRepository.save(servico);
	}

	@Override
	public Servico buscarServicoPorId(Integer id) {
		return servicoRepository.findById(id).orElseThrow(() -> new ServicoNaoEncontradoException());
	}

}
