package br.com.domain.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemServicoRealizadoRequest {
	@NotNull
	private Integer idServico;
	@NotNull
	private Integer quantidade;

}
