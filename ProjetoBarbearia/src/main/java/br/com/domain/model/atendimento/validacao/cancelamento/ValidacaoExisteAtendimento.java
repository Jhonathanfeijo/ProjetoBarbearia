package br.com.domain.model.atendimento.validacao.cancelamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.domain.model.atendimento.AtendimentoRepository;
@Component
public class ValidacaoExisteAtendimento implements ValidacaoCancelamento {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Override
	public void validar(Long idAtendimento) {
		boolean existeAtendimento = atendimentoRepository.existsById(idAtendimento);
		if(!existeAtendimento)
			throw new RuntimeException("Não existe atendimento marcado");
	}
	
}
