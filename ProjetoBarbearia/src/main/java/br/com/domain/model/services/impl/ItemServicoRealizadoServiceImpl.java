package br.com.domain.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.domain.model.entities.ItemServicoRealizado;
import br.com.domain.model.repositories.ItemServicoRealizadoRepository;
import br.com.domain.model.services.ItemServicoRealizadoService;

public class ItemServicoRealizadoServiceImpl implements ItemServicoRealizadoService {

	@Autowired
	private ItemServicoRealizadoRepository itemServicoRealizadoRepository;
	
	@Override
	public List<ItemServicoRealizado> salvarItensServicoRealizado(List<ItemServicoRealizado> itens) {
		return itens = itemServicoRealizadoRepository.saveAll(itens);
	}

}
