package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domain.model.entities.Usuario;
import br.com.domain.model.exceptions.UsuarioNaoEncontradoException;
import br.com.domain.model.repositories.UsuarioRepository;
import br.com.domain.model.services.UsuarioService;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Transactional
	@Override
	public Usuario atualizarUsuario(Usuario usuario, Integer id) {
		return usuarioRepository.findById(id).map(usuarioEncontrado -> {
			usuario.setId(id);
			usuarioRepository.save(usuario);
			return usuario;
		}).orElseThrow(() -> new UsuarioNaoEncontradoException());
	}

	@Transactional
	@Override
	public void excluirUsuario(Integer id) {
		usuarioRepository.findById(id).map(usuarioEncontrado -> {
			usuarioRepository.deleteById(id);
			return usuarioEncontrado;
		}).orElseThrow(() -> new UsuarioNaoEncontradoException());
	}

	@Transactional
	@Override
	public Usuario buscarUsuario(Integer id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException());
	}

	@Transactional
	@Override
	public boolean atualizarSenha(Integer id, String senhaNova, String senhaAtual) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException());
		boolean atualizou = false;
		if (senhaCorresponde(usuario, senhaAtual)) {
			usuario.setSenha(senhaNova);
			usuarioRepository.save(usuario);
			atualizou = true;
		}
		return atualizou;

	}

	@Override
	public String atualizarLogin(Integer id, String novoLogin) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException());
		usuario.setLogin(novoLogin);
		usuarioRepository.save(usuario);
		return novoLogin;
	}

	public boolean senhaCorresponde(Usuario usuario, String senha) {
		if (usuario.getSenha().equals(senha))
			return true;
		return false;
	}

}
