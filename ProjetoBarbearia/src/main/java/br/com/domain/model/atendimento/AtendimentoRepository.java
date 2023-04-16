package br.com.domain.model.atendimento;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{
	public boolean existsByFuncionarioIdAndHorarioMarcado(Long idFuncionario, LocalDateTime horarioMarcado);
}
