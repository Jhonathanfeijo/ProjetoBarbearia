package br.com.domain.model.atendimento.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemAtendimentoRepository extends JpaRepository<ItemAtendimento, Long> {

}
