package br.com.domain.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemServicoRealizadoRequest {
	
	private Integer idServico;
	private Integer quantidade;

}
