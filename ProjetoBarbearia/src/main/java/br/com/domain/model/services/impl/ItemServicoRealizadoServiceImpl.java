package br.com.domain.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.entities.ItemServicoRealizado;
import br.com.domain.model.repositories.ItemServicoRealizadoRepository;
import br.com.domain.model.services.ItemServicoRealizadoService;

@Service
public class ItemServicoRealizadoServiceImpl implements ItemServicoRealizadoService {

	@Autowired
	private ItemServicoRealizadoRepository itemServicoRealizadoRepository;

	@Override
	public List<ItemServicoRealizado> atualizarItemServicoRealizadoList(
			List<ItemServicoRealizado> itensServicoRealizado, Integer idServicoRealizado) {
		List<Integer> idItemServicoRealizadoList = itemServicoRealizadoRepository
				.buscarIdsItensServicoRealizado(idServicoRealizado);
		Integer contador = 0;
		for (Integer idItemServicoRealizado : idItemServicoRealizadoList) {
			if (contador < itensServicoRealizado.size()) {
				itensServicoRealizado.get(contador).setId(idItemServicoRealizado);
			} else {
				itemServicoRealizadoRepository.deleteById(idItemServicoRealizado);
			}
			contador++;
		}
		return itensServicoRealizado;
	}

}
