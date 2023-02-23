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

	// Transferir id de ItensServicoRealizado desatualizado para
	// ItensServicoRealizado Atualizado
	// Caso sobrar Itens, deletar esses itens do ServicoRealizado anterior
	@Override
	public List<ItemServicoRealizado> atualizarItemServicoRealizadoList(
			List<ItemServicoRealizado> itensServicoRealizado, Integer idServicoRealizado) {
		List<ItemServicoRealizado> itensDesatualizados = itemServicoRealizadoRepository
				.buscarItemServicoRealizadoListPorServicoRealizadoId(idServicoRealizado);
		Integer contador = 0;
		for (ItemServicoRealizado itemDesatualizado : itensDesatualizados) {
			if (contador < itensServicoRealizado.size()) {
				itensServicoRealizado.get(contador).setId(itemDesatualizado.getId());
				
			} else {
				itemServicoRealizadoRepository.deleteById(itemDesatualizado.getId());
			}
			contador++;
		}
		return itensServicoRealizado;
	}
}
