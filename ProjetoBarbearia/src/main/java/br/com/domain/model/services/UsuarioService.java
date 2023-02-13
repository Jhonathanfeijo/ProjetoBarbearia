package br.com.domain.model.services;

import br.com.domain.model.entities.Usuario;

public interface UsuarioService {

	public Usuario salvarUsuario (Usuario usuario);
	
	public Usuario atualizarUsuario(Usuario usuario, Integer id);
	
	public void excluirUsuario(Integer id);
	
	public Usuario buscarUsuario (Integer id);
	
	public boolean atualizarSenha(Integer id, String senhaNova, String senhaAtual);
	
	public String atualizarLogin(Integer id, String novoLogin);
	
}
