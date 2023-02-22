package br.com.domain.model.services.impl;

import org.springframework.stereotype.Service;

import br.com.domain.model.entities.Usuario;
import br.com.domain.model.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
//Atualizar usuario -> transferir id para Usuario atualizado
@Override
public Usuario atualizarUsuario(Usuario usuarioDesatualizado, Usuario usuarioAtualizado) {
	usuarioAtualizado.setId(usuarioDesatualizado.getId());
	return usuarioAtualizado;
	}
}
