package br.com.domain.model.services;

import br.com.domain.model.entities.DadosPessoais;

public interface DadosPessoaisService {
	
	public DadosPessoais salvarDadosPessoais(DadosPessoais dados);
	
	public DadosPessoais atualizarDadosPessoais(Integer id, DadosPessoais dados);
	
	public void excluirDadosPessoais(Integer id);
	
}
