package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.entities.DadosPessoais;
import br.com.domain.model.exceptions.DadosPessoaisNaoEncontradoException;
import br.com.domain.model.repositories.DadosPessoaisRepository;
import br.com.domain.model.services.DadosPessoaisService;

@Service
public class DadosPessoaisServiceImpl implements DadosPessoaisService {
	
	@Autowired
	private DadosPessoaisRepository dadosPessoaisRepository;

	@Override
	public DadosPessoais salvarDadosPessoais(DadosPessoais dados) {
		return dadosPessoaisRepository.save(dados);
	}

	@Override
	public DadosPessoais atualizarDadosPessoais(Integer id, DadosPessoais dados) {
		DadosPessoais dadosEncontrados = buscarDadosPessoaisPorId(id);	
		dados.setId(dadosEncontrados.getId());
		return dadosPessoaisRepository.save(dados);
	}

	@Override
	public void excluirDadosPessoais(Integer id) {
		DadosPessoais dadosEncontrados = buscarDadosPessoaisPorId(id);
		dadosPessoaisRepository.deleteById(dadosEncontrados.getId());
	}

	@Override
	public DadosPessoais buscarDadosPessoaisPorId(Integer id) {
		return  dadosPessoaisRepository.findById(id).orElseThrow(() -> new DadosPessoaisNaoEncontradoException());
	}
	
	
}