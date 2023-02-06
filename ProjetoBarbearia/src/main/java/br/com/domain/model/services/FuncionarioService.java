package br.com.domain.model.services;

import br.com.domain.model.entities.Funcionario;

public interface FuncionarioService {
	
	public Funcionario salvarFuncionario (Funcionario funcionario);
	
	public void excluirFuncionarioPorId(Integer id);
	
	public Funcionario buscarFuncionarioPorId(Integer id);
}
