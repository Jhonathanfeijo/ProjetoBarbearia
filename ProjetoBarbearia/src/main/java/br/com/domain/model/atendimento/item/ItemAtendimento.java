package br.com.domain.model.atendimento.item;

import java.math.BigDecimal;

import br.com.domain.model.Servico.Servico;
import br.com.domain.model.atendimento.Atendimento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ItemAtendimento")
@Table(name = "item_atendimento")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class ItemAtendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_atendimento")
	private Atendimento atendimento;

	private Integer quantidade;
	@JoinColumn(name = "id_servico")
	@ManyToOne
	private Servico servico;

	private BigDecimal valorItem;

	public ItemAtendimento(Integer quantidade, Servico servico) {
		this.quantidade = quantidade;
		this.servico = servico;
		this.valorItem = servico.getValorServico().multiply(new BigDecimal(String.valueOf(quantidade)));
	}

}
