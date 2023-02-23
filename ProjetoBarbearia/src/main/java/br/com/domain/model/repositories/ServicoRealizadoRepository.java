package br.com.domain.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.domain.model.entities.ServicoRealizado;

@Repository
public interface ServicoRealizadoRepository extends JpaRepository<ServicoRealizado,Integer> {
	//Lista servicos realizados pelo cliente
	@Query(value = "SELECT * FROM servico_realizado sr where sr.cliente_id=:id", nativeQuery = true)
	public List<ServicoRealizado> buscarServicoRealizadoListPorClienteId(@Param("id")Integer id);
	//Retorna o numero de servicos realizados pelo cliente
	@Query(value = "SELECT COUNT(*) FROM servico_realizado sr where cliente_id=:id", nativeQuery = true)
	public Integer obterQuantidadeServicosRealizadosPorClienteId(@Param("id") Integer id);

}
