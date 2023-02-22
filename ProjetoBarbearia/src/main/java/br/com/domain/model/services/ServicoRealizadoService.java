package br.com.domain.model.services;

import java.util.List;

import br.com.domain.model.dto.request.ServicoRealizadoRequest;
import br.com.domain.model.dto.response.ServicoRealizadoResponse;
import br.com.domain.model.entities.ServicoRealizado;

public interface ServicoRealizadoService {

	public ServicoRealizadoResponse salvarServicoRealizado(ServicoRealizadoRequest servicoRealizadoRequest);

	public ServicoRealizadoResponse atualizarServicoRealizado(ServicoRealizadoRequest servicoRealizadoRequest, Integer id);

	public void deletarServicoRealizadoPorId(Integer id);

	public ServicoRealizado buscarServicoRealizadoPorId(Integer id);
	
	public ServicoRealizadoResponse obterServicoRealizadoResponse(Integer id);
	
	public List<ServicoRealizado> buscarServicosRealizadosPorClienteId(Integer id);
	
	public Integer obterQuantidadeServicosRealizadosPorClienteId(Integer id);

}
