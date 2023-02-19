package br.com.domain.model.regraDeNegocio;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.domain.model.entities.ItemServicoRealizado;
@Component
public class CalcularValorServicoRealizado {

	public BigDecimal calcularValorServicoRealizado(List<ItemServicoRealizado> itens) {
		BigDecimal valorServicoRealizado = new BigDecimal("0.0");
		for (ItemServicoRealizado item : itens) {
			String quantidadeString = String.valueOf(item.getQuantidade());
			BigDecimal valorServico = item.getServico().getValorServico();
			valorServico = valorServico.multiply(new BigDecimal(quantidadeString));
			valorServicoRealizado = valorServicoRealizado.add(valorServico);
		}
		return valorServicoRealizado;
	}
}
