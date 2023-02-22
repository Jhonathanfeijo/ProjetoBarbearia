package br.com.domain.model.dto.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicoRealizadoResponse {
	private String nomeCliente;
	private String nomeFuncionario;
	private List<ItemServicoRealizadoResponse> itens;
	private BigDecimal valorTotal;
	private String horaConclusao;
	
}
