package br.com.domain.model.services.impl;

import org.springframework.stereotype.Service;

import br.com.domain.model.entities.DadosPessoais;
import br.com.domain.model.services.DadosPessoaisService;

@Service
public class DadosPessoaisServiceImpl implements DadosPessoaisService {

	@Override
	public DadosPessoais atualizarDadosPessoais(DadosPessoais dadosDesatualizados, DadosPessoais dadosAtualizados) {
		dadosAtualizados.setId(dadosDesatualizados.getId());
		return dadosAtualizados;
	}
	
}
