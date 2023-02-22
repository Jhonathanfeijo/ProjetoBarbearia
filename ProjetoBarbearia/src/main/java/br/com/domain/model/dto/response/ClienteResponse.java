package br.com.domain.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteResponse {

	private DadosPessoaisResponse dadosPessoais;
	private Integer quantidadeServicosRealizados;
	
}
