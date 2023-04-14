package br.com.domain.model.Servico;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Servico")
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "servico")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nomeServico;

	private BigDecimal valorServico;

	private Integer duracaoMinutos;
	
	private boolean ativo;

	public Servico(ServicoDadosCadastro dados) {
		this.ativo = true;
		this.nomeServico = dados.getNomeServico();
		this.duracaoMinutos = dados.getDuracaoMinutos();
		this.valorServico = dados.getValor();
	}

	public void atualizar(ServicoDadosAtualizacao servico) {
		
		if (servico.getNomeServico() != null) {
			this.nomeServico = servico.getNomeServico();
		}
		if (servico.getDuracaoMinutos() != null) {
			this.duracaoMinutos = servico.getDuracaoMinutos();
		}
		if (servico.getValor() != null) {
			this.valorServico = servico.getValor();
		}
	}
	
	public void desativar() {
		this.ativo = false;
	}
}
