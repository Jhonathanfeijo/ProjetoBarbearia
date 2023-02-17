package br.com.domain.model.dto.request.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.domain.model.dto.request.ServicoRealizadoRequest;
import br.com.domain.model.dto.response.ItemServicoRealizadoResponse;
import br.com.domain.model.dto.response.ServicoRealizadoResponse;
import br.com.domain.model.entities.Cliente;
import br.com.domain.model.entities.Funcionario;
import br.com.domain.model.entities.ItemServicoRealizado;
import br.com.domain.model.entities.ServicoRealizado;
import br.com.domain.model.regraDeNegocio.CalcularValorServicoRealizado;
import br.com.domain.model.services.ClienteService;
import br.com.domain.model.services.FuncionarioService;

public class ServicoRealizadoMapper {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private ClienteService clienteService;

	private CalcularValorServicoRealizado calcularValorServicoRealizado;

	private ItemServicoRealizadoMapper itemServicoRealizadoMapper;

	public ServicoRealizado toServicoRealizado(ServicoRealizadoRequest servicoRealizadoRequest) {
		Cliente cliente = clienteService.buscarClientePorId(servicoRealizadoRequest.getIdCliente());
		Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(servicoRealizadoRequest.getIdFuncionario());
		List<ItemServicoRealizado> itensServicoRealizado = itemServicoRealizadoMapper
				.toItemServicoRealizadoList(servicoRealizadoRequest.getItens());
		BigDecimal valorTotal = calcularValorServicoRealizado.calcularValorServicoRealizado(itensServicoRealizado);
		ServicoRealizado servicoRealizado = new ServicoRealizado();
		servicoRealizado.setCliente(cliente);
		servicoRealizado.setFuncionario(funcionario);
		servicoRealizado.setItens(itensServicoRealizado);
		servicoRealizado.setValorTotal(valorTotal);
		return servicoRealizado;
	}

	public ServicoRealizadoResponse toServicoRealizadoResponse (ServicoRealizado servicoRealizado) {
		ServicoRealizadoResponse servicoRealizadoResponse = new ServicoRealizadoResponse();
		servicoRealizadoResponse.setNomeCliente(servicoRealizado.getCliente().getDadosPessoais().getNome());
		servicoRealizadoResponse.setNomeFuncionario(servicoRealizado.getFuncionario().getDadosPessoais().getNome());
		servicoRealizadoResponse.setValorTotal(servicoRealizado.getValorTotal());
		List<ItemServicoRealizadoResponse> itensServicoRealizadoResponse = itemServicoRealizadoMapper.toItemServicoRealizadoResponseList(servicoRealizado.getItens());
		servicoRealizadoResponse.setItens(itensServicoRealizadoResponse);
		return servicoRealizadoResponse;
	}
}
