package br.com.domain.model.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.Servico.Servico;
import br.com.domain.model.Servico.ServicoRepository;
import br.com.domain.model.atendimento.item.ItemAtendimento;
import br.com.domain.model.atendimento.item.ItemAtendimentoAgendamento;
import br.com.domain.model.atendimento.validacao.agendamento.ValidacaoAgendamento;
import br.com.domain.model.atendimento.validacao.cancelamento.ValidacaoCancelamento;
import br.com.domain.model.cliente.Cliente;
import br.com.domain.model.cliente.ClienteRepository;
import br.com.domain.model.funcionario.Funcionario;
import br.com.domain.model.funcionario.FuncionarioRepository;

@Service
public class AgendaAtendimento {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private List<ValidacaoAgendamento> validacoesAgendamento;

	@Autowired
	private List<ValidacaoCancelamento> validacaoCancelamento;

	public Atendimento agendar(AtendimentoDadosAgendamento dados) {

		validacoesAgendamento.forEach(v -> v.validar(dados));

		Cliente cliente = clienteRepository.getReferenceById(dados.getIdCliente());
		Funcionario funcionario = funcionarioRepository.getReferenceById(dados.getIdFuncionario());
		List<ItemAtendimento> itens = obterItensAtendimento(dados.getItens());
		Atendimento atendimento = atendimentoRepository
				.save(new Atendimento(cliente, funcionario, itens, dados.getHorario()));
		return atendimento;
	}

	public void cancelar(Long id) {
		Atendimento atendimento = atendimentoRepository.getReferenceById(id);
		validacaoCancelamento.forEach(v -> v.validar(id));
		atendimento.cancelar();
	}

	private List<ItemAtendimento> obterItensAtendimento(List<ItemAtendimentoAgendamento> itens) {
		return itens.stream().map(item -> {
			Servico servico = servicoRepository.getReferenceById(item.getIdServico());
			return new ItemAtendimento(item.getQuantidade(), servico);
		}).toList();
	}
}
