package br.com.domain.model.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.domain.model.entities.Usuario;
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
		}).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
	}
	@Transactional
	@Override
	public void excluirUsuario(Integer id) {
		usuarioRepository.findById(id).map(usuarioEncontrado ->{
			usuarioRepository.deleteById(id);
			return usuarioEncontrado;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
	}
	@Transactional
	@Override
	public Usuario buscarUsuario(Integer id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado"));
	}

	
}
