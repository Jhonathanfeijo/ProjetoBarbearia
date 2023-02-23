package br.com.domain.model.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ServicoResponse {
	private String nomeServico;
	private BigDecimal valorServico;
	private Integer duracaoMinutosServico;
}
