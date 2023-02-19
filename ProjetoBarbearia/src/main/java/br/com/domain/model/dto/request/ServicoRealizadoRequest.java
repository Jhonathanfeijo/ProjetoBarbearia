package br.com.domain.model.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServicoRealizadoRequest {
	@NotNull
	private Integer idCliente;
	@NotNull
	private Integer idFuncionario;
	private List<ItemServicoRealizadoRequest> itens;
}
