package br.com.domain.model.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="servico_realizado")
public class ServicoRealizado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	private BigDecimal valorTotal;
	@OneToMany(mappedBy = "servicoRealizado")
	private List<ItemServicoRealizado> itens;
	
}
