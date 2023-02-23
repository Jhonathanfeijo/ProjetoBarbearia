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
	
	//Listar itens de determinado servico realizado
	@Query(value = "SELECT * FROM item_servico_realizado where servico_realizado_id=:id", nativeQuery = true)
	public List<ItemServicoRealizado> buscarItemServicoRealizadoListPorServicoRealizadoId(@Param("id")Integer id);
	
}
