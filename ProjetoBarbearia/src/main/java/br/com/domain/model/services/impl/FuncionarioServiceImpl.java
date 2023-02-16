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
	private UsuarioService usuarioService;
	
	@Autowired
	private DadosPessoaisService dadosPessoaisService;
	@Transactional
	@Override
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		funcionario.getUsuario().setFuncionario(true);
		Usuario usuario = usuarioService.salvarUsuario(funcionario.getUsuario());
		DadosPessoais dadosPessoais = dadosPessoaisService.salvarDadosPessoais(funcionario.getDadosPessoais());
		funcionario.setDadosPessoais(dadosPessoais);
		funcionario.setUsuario(usuario);
		return funcionarioRepository.save(funcionario);
	}
	@Transactional
	@Override
	public void excluirFuncionarioPorId(Integer id) {
		Funcionario funcionarioEncontrado = buscarFuncionarioPorId(id);
		Integer idUsuario = funcionarioEncontrado.getUsuario().getId();
		usuarioService.excluirUsuario(idUsuario);		
		Integer idDadosPessoais = funcionarioEncontrado.getDadosPessoais().getId();
		dadosPessoaisService.excluirDadosPessoais(idDadosPessoais);
		funcionarioRepository.deleteById(id);
	}

	@Override
	public Funcionario buscarFuncionarioPorId(Integer id) {
		return funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioNaoEncontradoException());
	}

}
