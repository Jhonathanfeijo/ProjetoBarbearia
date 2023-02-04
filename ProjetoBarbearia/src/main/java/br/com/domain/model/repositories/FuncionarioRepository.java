package br.com.domain.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.domain.model.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer> {

}
