package br.com.domain.model.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemServicoRealizadoResponse {
	
	private Integer quantidade;
	private BigDecimal valorServico;
	private String nomeServico;

}
