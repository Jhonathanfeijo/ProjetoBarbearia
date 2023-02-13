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
		return dadosPessoaisRepository.findById(id).map(dadosEncontrados ->{
			dados.setId(id);
			return dadosPessoaisRepository.save(dados);
		}).orElseThrow(() -> new DadosPessoaisNaoEncontradoException());
	}

	@Override
	public void excluirDadosPessoais(Integer id) {
		dadosPessoaisRepository.findById(id).map(dadosEncontrados ->{
			dadosPessoaisRepository.deleteById(id);
			return dadosEncontrados;
		}).orElseThrow(() -> new DadosPessoaisNaoEncontradoException());
	}
}