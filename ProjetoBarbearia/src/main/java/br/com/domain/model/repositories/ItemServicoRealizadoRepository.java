package br.com.domain.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.domain.model.entities.ItemServicoRealizado;

@Repository
public interface ItemServicoRealizadoRepository extends JpaRepository<ItemServicoRealizado,Integer> {
	
	@Modifying
	@Query(value = "DELETE FROM item_servico_realizado where servico_realizado_id =:id", nativeQuery = true)
	public void deletarItensDoPedido(@Param("id")Integer id);
	
	@Query(value = "SELECT * FROM item_servico_realizado where servico_realizado_id=:id", nativeQuery = true)
	public List<ItemServicoRealizado> buscarItemServicoRealizadoPorServicoRealizado(@Param("id")Integer id);
	
	@Query(value = "SELECT id FROM item_servico_realizado where servico_realizado_id=:id", nativeQuery = true)
	public List<Integer> buscarIdsItensServicoRealizado(@Param("id") Integer id);

}
