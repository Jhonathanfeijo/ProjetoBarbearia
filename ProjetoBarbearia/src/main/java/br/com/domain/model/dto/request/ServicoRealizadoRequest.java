package br.com.domain.model.dto.request;

import java.util.List;

public class ServicoRealizadoRequest {

	public Integer idCliente;
	public Integer idFuncionario;
	public List<ItemServicoRealizadoRequest> itens;
}
