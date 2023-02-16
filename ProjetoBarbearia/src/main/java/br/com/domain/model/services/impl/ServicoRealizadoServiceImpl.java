package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.entities.ServicoRealizado;
import br.com.domain.model.exceptions.ServicoRealizadoNaoEncontradoException;
import br.com.domain.model.repositories.ServicoRealizadoRepository;
import br.com.domain.model.services.ClienteService;
import br.com.domain.model.services.FuncionarioService;
import br.com.domain.model.services.ItemServicoRealizadoService;
import br.com.domain.model.services.ServicoRealizadoService;
import br.com.domain.model.services.ServicoService;

@Service
public class ServicoRealizadoServiceImpl implements ServicoRealizadoService {

	@Autowired
	private ServicoRealizadoRepository servicoRealizadoRepository;

	@Autowired
	private ServicoService servicoService;

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ItemServicoRealizadoService itemServicoRealizadoService;

	@Override
	public ServicoRealizado salvarServicoRealizado(ServicoRealizado servicoRealizado) {
		return servicoRealizadoRepository.save(servicoRealizado);
	}

	@Override
	public ServicoRealizado atualizarServicoRealizado(ServicoRealizado servicoRealizado, Integer id) {
		ServicoRealizado servicoRealizadoEncontrado = buscarServicoRealizadoPorId(id);
		servicoRealizado.setId(servicoRealizadoEncontrado.getId());
		return servicoRealizadoRepository.save(servicoRealizado);
	}

	@Override
	public void deletarServicoRealizadoPorId(Integer id) {
		ServicoRealizado servicoRealizadoEncontrado = buscarServicoRealizadoPorId(id);
		servicoRealizadoRepository.deleteById(servicoRealizadoEncontrado.getId());
	}

	@Override
	public ServicoRealizado buscarServicoRealizadoPorId(Integer id) {
		return servicoRealizadoRepository.findById(id).orElseThrow(() -> new ServicoRealizadoNaoEncontradoException());
	}

}
