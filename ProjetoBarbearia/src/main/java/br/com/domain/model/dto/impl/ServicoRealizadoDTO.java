package br.com.domain.model.dto.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.domain.model.dto.request.ServicoRealizadoRequest;
import br.com.domain.model.dto.response.ItemServicoRealizadoResponse;
import br.com.domain.model.dto.response.ServicoRealizadoResponse;
import br.com.domain.model.entities.Cliente;
import br.com.domain.model.entities.Funcionario;
import br.com.domain.model.entities.ItemServicoRealizado;
import br.com.domain.model.entities.ServicoRealizado;
import br.com.domain.model.regraDeNegocio.CalcularDateTimeServicoRealizado;
import br.com.domain.model.regraDeNegocio.CalcularValorServicoRealizado;
import br.com.domain.model.services.ClienteService;
import br.com.domain.model.services.FuncionarioService;
@Component
public class ServicoRealizadoDTO {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ItemServicoRealizadoDTO itemServicoRealizadoDTO;
	
	@Autowired
	private CalcularValorServicoRealizado calcularValorServicoRealizado;
	
	@Autowired
	private CalcularDateTimeServicoRealizado calcularDateTimeServicoRealizado;
	
	//Converter ServicoRealizadoRequest para ServicoRealizado
	public ServicoRealizado toServicoRealizado(ServicoRealizadoRequest servicoRealizadoRequest) {
		Cliente cliente = clienteService.buscarClientePorId(servicoRealizadoRequest.getIdCliente());
		Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(servicoRealizadoRequest.getIdFuncionario());
		List<ItemServicoRealizado> itensServicoRealizado = itemServicoRealizadoDTO
				.toItemServicoRealizadoList(servicoRealizadoRequest.getItens());
		LocalDateTime horaConclusao = calcularDateTimeServicoRealizado.calcularConclusao(itensServicoRealizado, LocalDateTime.now());
		BigDecimal valorTotal = calcularValorServicoRealizado.calcularValorServicoRealizado(itensServicoRealizado);
		return ServicoRealizado.builder().cliente(cliente).funcionario(funcionario).valorTotal(valorTotal).horaConclusao(horaConclusao).itens(itensServicoRealizado).build();
	}

	//Converter ServicoRealizado para ServicoRealizadoResponse
	public ServicoRealizadoResponse toServicoRealizadoResponse (ServicoRealizado servicoRealizado) {
		String nomeCliente = servicoRealizado.getCliente().getDadosPessoais().getNome();
		String nomeFuncionario = servicoRealizado.getFuncionario().getDadosPessoais().getNome();
		BigDecimal valorTotal = servicoRealizado.getValorTotal();
		List<ItemServicoRealizadoResponse> itensServicoRealizadoResponse = itemServicoRealizadoDTO.toItemServicoRealizadoResponseList(servicoRealizado.getItens());
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		String horaConclusao = formatador.format(servicoRealizado.getHoraConclusao());
		return ServicoRealizadoResponse.builder().nomeCliente(nomeCliente).nomeFuncionario(nomeFuncionario)
				.valorTotal(valorTotal).itens(itensServicoRealizadoResponse).horaConclusao(horaConclusao).build();
	}
}
