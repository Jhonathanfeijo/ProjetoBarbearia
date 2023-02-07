package br.com.domain.model.services;

import br.com.domain.model.entities.ServicoRealizado;

public interface ServicoRealizadoService {

	public ServicoRealizado salvarServicoRealizado(ServicoRealizado servicoRealizado);

	public ServicoRealizado atualizarServicoRealizado(ServicoRealizado servicoRealizado, Integer id);

	public void deletarServicoRealizadoPorId(Integer id);

	public ServicoRealizado buscarServicoRealizadoPorId(Integer id);

}
