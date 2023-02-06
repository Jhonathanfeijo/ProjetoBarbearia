package br.com.domain.model.services;

import br.com.domain.model.entities.Usuario;

public interface UsuarioService {

	public Usuario salvarUsuario (Usuario usuario);
	
	public Usuario atualizarUsuario(Usuario usuario, Integer id);
	
	public void excluirUsuario(Integer id);
	
	public Usuario buscarUsuario (Integer id);
	
}
