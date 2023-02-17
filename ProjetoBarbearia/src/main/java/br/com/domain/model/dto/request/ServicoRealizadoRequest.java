package br.com.domain.model.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicoRealizadoRequest {

	private Integer idCliente;
	private Integer idFuncionario;
	private List<ItemServicoRealizadoRequest> itens;
}
