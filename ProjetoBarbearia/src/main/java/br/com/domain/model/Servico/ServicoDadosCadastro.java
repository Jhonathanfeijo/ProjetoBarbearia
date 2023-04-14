package br.com.domain.model.Servico;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ServicoDadosCadastro {
	
	@NotNull
	private Integer duracaoMinutos;
	@NotBlank
	private String nomeServico;
	@NotNull
	private BigDecimal valor;
	
}
