package br.com.domain.model.services;

import br.com.domain.model.entities.Servico;

public interface ServicoService {
	
	public Servico salvarServico(Servico servico);
	
	public void deletarServico(Integer id);
	
	public Servico atualizarServico(Servico servico, Integer id);
	
	public Servico buscarServicoPorId(Integer id);

}
