package br.com.domain.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioResponse {

	private String nomeFuncionario;
	private String rg;
	private String cpf;
}
