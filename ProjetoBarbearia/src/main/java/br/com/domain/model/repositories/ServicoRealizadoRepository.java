package br.com.domain.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.domain.model.entities.ServicoRealizado;

@Repository
public interface ServicoRealizadoRepository extends JpaRepository<ServicoRealizado,Integer> {

}
