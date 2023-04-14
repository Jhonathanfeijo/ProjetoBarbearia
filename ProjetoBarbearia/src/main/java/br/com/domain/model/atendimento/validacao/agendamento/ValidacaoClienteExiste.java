package br.com.domain.model.atendimento.validacao.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.domain.model.atendimento.AtendimentoDadosAgendamento;
import br.com.domain.model.cliente.ClienteRepository;

@Component
public class ValidacaoClienteExiste implements ValidacaoAgendamento {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void validar(AtendimentoDadosAgendamento dados) {
		boolean clienteExiste = clienteRepository.existsById(dados.getIdCliente());
		if(!clienteExiste)
			throw new RuntimeException("Cliente não existe");
	}

}
