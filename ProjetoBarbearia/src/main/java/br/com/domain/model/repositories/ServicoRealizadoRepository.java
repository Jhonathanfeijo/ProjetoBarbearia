package br.com.domain.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.domain.model.entities.ServicoRealizado;

@Repository
public interface ServicoRealizadoRepository extends JpaRepository<ServicoRealizado,Integer> {
	
	@Query(value = "SELECT * FROM servico_realizado sr where sr.cliente_id=:id", nativeQuery = true)
	public List<ServicoRealizado> buscarServicoRealizadoPorClienteId(@Param("id")Integer id);

}
