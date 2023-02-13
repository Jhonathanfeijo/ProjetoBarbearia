package br.com.domain.model.dto.response;

import java.math.BigDecimal;
import java.util.List;

public class ServicoRealizadoResponse {
	public String nomeCliente;
	public String nomeFuncionario;
	public List<ItemServicoRealizadoResponse> itens;
	public BigDecimal precoServicoRealizado;
	
}
