package br.com.domain.model.services;

import br.com.domain.model.entities.Usuario;

public interface UsuarioService {

	public Usuario atualizarUsuario(Usuario usuarioDesatualizado, Usuario usuarioAtualizado);
}
