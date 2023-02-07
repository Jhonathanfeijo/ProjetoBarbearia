package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.entities.Funcionario;
import br.com.domain.model.entities.Usuario;
import br.com.domain.model.exceptions.FuncionarioNaoEncontradoException;
import br.com.domain.model.repositories.FuncionarioRepository;
import br.com.domain.model.services.FuncionarioService;
import br.com.domain.model.services.UsuarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		Usuario usuario = funcionario.getUsuario();
		usuario = usuarioService.salvarUsuario(usuario);
		funcionario.setUsuario(usuario);
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public void excluirFuncionarioPorId(Integer id) {
		funcionarioRepository.findById(id).map(funcionarioEncontrado -> {
			Integer idUsuario = funcionarioEncontrado.getUsuario().getId();
			usuarioService.excluirUsuario(idUsuario);
			funcionarioRepository.deleteById(id);
			return funcionarioEncontrado;
		}).orElseThrow(() -> new FuncionarioNaoEncontradoException());
	}

	@Override
	public Funcionario buscarFuncionarioPorId(Integer id) {
		return funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioNaoEncontradoException());
	}

}
