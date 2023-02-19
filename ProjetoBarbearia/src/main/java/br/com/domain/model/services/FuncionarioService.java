package br.com.domain.model.services;

import br.com.domain.model.dto.response.FuncionarioResponse;
import br.com.domain.model.entities.Funcionario;

public interface FuncionarioService {
	
	public FuncionarioResponse salvarFuncionario (Funcionario funcionario);
	
	public void excluirFuncionarioPorId(Integer id);
	
	public FuncionarioResponse atualizarFuncionarioPorId(Funcionario funcionario, Integer id);
	
	public Funcionario buscarFuncionarioPorId(Integer id);
		
	public FuncionarioResponse buscarFuncionarioResponse(Integer id);
}
