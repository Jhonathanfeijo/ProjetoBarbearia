package br.com.domain.model.atendimento.validacao.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.domain.model.Servico.ServicoRepository;
import br.com.domain.model.atendimento.AtendimentoDadosAgendamento;
import br.com.domain.model.atendimento.item.ItemAtendimentoAgendamento;

@Component
public class ValidacaoServicoExiste implements ValidacaoAgendamento {

	@Autowired
	private ServicoRepository servicoRepository;

	@Override
	public void validar(AtendimentoDadosAgendamento dados) {
		for (ItemAtendimentoAgendamento item : dados.getItens()) {
			boolean existeServico = servicoRepository.existsById(item.getIdServico());
			if (!existeServico)
				throw new RuntimeException("Serviço não cadastrado");
		}
	}

}
