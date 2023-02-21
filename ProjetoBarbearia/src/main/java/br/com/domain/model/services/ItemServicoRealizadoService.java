package br.com.domain.model.services;

import java.util.List;

import br.com.domain.model.entities.ItemServicoRealizado;

public interface ItemServicoRealizadoService {
	
	public List<ItemServicoRealizado> atualizarItemServicoRealizadoList(List<ItemServicoRealizado> itensServicoRealizado, Integer idServicoRealizado);

}
