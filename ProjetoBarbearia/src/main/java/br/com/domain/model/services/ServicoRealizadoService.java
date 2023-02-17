package br.com.domain.model.services;

import br.com.domain.model.dto.request.ServicoRealizadoRequest;
import br.com.domain.model.dto.response.ServicoRealizadoResponse;
import br.com.domain.model.entities.ServicoRealizado;

public interface ServicoRealizadoService {

	public ServicoRealizadoResponse salvarServicoRealizado(ServicoRealizadoRequest servicoRealizadoRequest);

	public ServicoRealizado atualizarServicoRealizado(ServicoRealizado servicoRealizado, Integer id);

	public void deletarServicoRealizadoPorId(Integer id);

	public ServicoRealizado buscarServicoRealizadoPorId(Integer id);

}
