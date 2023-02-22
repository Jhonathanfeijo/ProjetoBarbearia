package br.com.domain.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosPessoaisResponse {
	
	private String nome;
	private String cpf;
	private String rg;
	private String dataNascimento;

}
