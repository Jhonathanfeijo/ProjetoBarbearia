package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.dto.impl.FuncionarioDTO;
import br.com.domain.model.dto.response.FuncionarioResponse;
import br.com.domain.model.entities.DadosPessoais;
import br.com.domain.model.entities.Funcionario;
import br.com.domain.model.entities.Usuario;
import br.com.domain.model.exceptions.FuncionarioNaoEncontradoException;
import br.com.domain.model.repositories.FuncionarioRepository;
import br.com.domain.model.services.DadosPessoaisService;
import br.com.domain.model.services.FuncionarioService;
import br.com.domain.model.services.UsuarioService;
import jakarta.transaction.Transactional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private FuncionarioDTO funcionarioDTO;

	@Autowired
	private DadosPessoaisService dadosPessoaisService;

	@Autowired
	private UsuarioService usuarioService;

	@Transactional
	@Override
	public FuncionarioResponse salvarFuncionario(Funcionario funcionario) {
		funcionario = funcionarioRepository.save(funcionario);
		return toFuncionarioResponse(funcionario);
	}

	@Transactional
	@Override
	public FuncionarioResponse atualizarFuncionarioPorId(Funcionario funcionario, Integer id) {
		Funcionario funcionarioEncontrado = buscarFuncionarioPorId(id);
		DadosPessoais dadosPessoais = dadosPessoaisService
				.atualizarDadosPessoais(funcionarioEncontrado.getDadosPessoais(), funcionario.getDadosPessoais());
		Usuario usuario = usuarioService.atualizarUsuario(funcionarioEncontrado.getUsuario(), funcionario.getUsuario());
		funcionario.setDadosPessoais(dadosPessoais);
		funcionario.setId(funcionarioEncontrado.getId());
		funcionario.setUsuario(usuario);
		return salvarFuncionario(funcionarioEncontrado);
	}

	@Transactional
	@Override
	public void excluirFuncionarioPorId(Integer id) {
		buscarFuncionarioPorId(id);
		funcionarioRepository.deleteById(id);
	}

	@Override
	public Funcionario buscarFuncionarioPorId(Integer id) {
		return funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioNaoEncontradoException());
	}

	@Override
	public FuncionarioResponse buscarFuncionarioResponse(Integer id) {
		Funcionario funcionario = buscarFuncionarioPorId(id);
		return toFuncionarioResponse(funcionario);
	}

	public FuncionarioResponse toFuncionarioResponse(Funcionario funcionario) {
		return funcionarioDTO.toFuncionarioResponse(funcionario);
	}
}
