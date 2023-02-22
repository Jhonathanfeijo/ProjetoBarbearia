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
	
	//Salvar servico
	@Transactional
	@Override
	public Servico salvarServico(Servico servico) {
		return servicoRepository.save(servico);
	}

	//Deletar Servico por id
	@Transactional
	@Override
	public void deletarServico(Integer id) {
		buscarServicoPorId(id);
		servicoRepository.deleteById(id);
	}

	//Atualizar servico por id
	@Transactional
	@Override
	public Servico atualizarServico(Servico servico, Integer id) {
		buscarServicoPorId(id);
		servico.setId(id);
		return servicoRepository.save(servico);
	}

	//Buscar servico por id
	@Override
	public Servico buscarServicoPorId(Integer id) {
		return servicoRepository.findById(id).orElseThrow(() -> new ServicoNaoEncontradoException());
	}

}
