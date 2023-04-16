package br.com.domain.model.atendimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.domain.model.atendimento.item.ItemAtendimento;
import br.com.domain.model.cliente.Cliente;
import br.com.domain.model.funcionario.Funcionario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Atendimento")
@Table(name = "atendimento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Atendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name = "id_cliente")
	@ManyToOne
	private Cliente cliente;

	@JoinColumn(name = "id_funcionario")
	@ManyToOne
	private Funcionario funcionario;

	private LocalDateTime horarioMarcado;

	private LocalDateTime horarioFinal;

	private BigDecimal valorAtendimento;

	@Enumerated(EnumType.STRING)
	private Status status;
	@OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
	private List<ItemAtendimento> itens;

	public Atendimento(Cliente cliente, Funcionario funcionario, List<ItemAtendimento> itens, LocalDateTime horarioMarcado) {
		this.status = Status.MARCADO;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.itens = atribuirAtendimentoEmListaItens(itens);
		this.horarioMarcado = horarioMarcado;
		this.valorAtendimento = obterValorTotalAtendimento(itens);
		this.horarioFinal = obterHorarioFinal(horarioMarcado, itens);
	}

	private BigDecimal obterValorTotalAtendimento(List<ItemAtendimento> itens) {
		BigDecimal valorTotal = new BigDecimal("0.0");
		for (ItemAtendimento item : itens) {
			valorTotal = valorTotal.add(item.getValorItem());
		}
		return valorTotal;
	}

	private LocalDateTime obterHorarioFinal(LocalDateTime horarioInicio, List<ItemAtendimento> itens) {
		LocalDateTime horarioFinal = horarioInicio;
		for (ItemAtendimento item : itens) {
			Integer minutos = item.getServico().getDuracaoMinutos() * item.getQuantidade();
			horarioFinal = horarioFinal.plusMinutes(minutos);
		}
		return horarioFinal;
	}
	
	private List<ItemAtendimento> atribuirAtendimentoEmListaItens(List<ItemAtendimento> itens){
		for(ItemAtendimento item : itens) {
			item.setAtendimento(this);
		}
		return itens;
	}

	public void cancelar() {
		
		this.status = Status.CANCELADO;
	}
}
