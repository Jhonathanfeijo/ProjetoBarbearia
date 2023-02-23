package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	private DadosPessoaisService dadosPessoaisService;

	@Autowired
	private UsuarioService usuarioService;

	//Salvar funcionário
	@Transactional
	@Override
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	//Atualizar funcionario por id
	@Transactional
	@Override
	public Funcionario atualizarFuncionarioPorId(Funcionario funcionario, Integer id) {
		Funcionario funcionarioEncontrado = buscarFuncionarioPorId(id);
		DadosPessoais dadosPessoais = dadosPessoaisService
				.atualizarDadosPessoais(funcionarioEncontrado.getDadosPessoais(), funcionario.getDadosPessoais());
		Usuario usuario = usuarioService.atualizarUsuario(funcionarioEncontrado.getUsuario(), funcionario.getUsuario());
		funcionario.setDadosPessoais(dadosPessoais);
		funcionario.setId(funcionarioEncontrado.getId());
		funcionario.setUsuario(usuario);
		return salvarFuncionario(funcionarioEncontrado);
	}

	//Excluir funcionario por id
	@Transactional
	@Override
	public void excluirFuncionarioPorId(Integer id) {
		buscarFuncionarioPorId(id);
		funcionarioRepository.deleteById(id);
	}
	
	//Buscar funcionario por id
	@Override
	public Funcionario buscarFuncionarioPorId(Integer id) {
		return funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioNaoEncontradoException());
	}

}
