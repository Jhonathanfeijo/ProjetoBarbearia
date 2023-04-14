package br.com.domain.model.Servico;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ServicoDadosAtualizacao {
	
	@NotNull
	private Long id;
	private String nomeServico;
	private Integer duracaoMinutos;
	private BigDecimal valor;
}
