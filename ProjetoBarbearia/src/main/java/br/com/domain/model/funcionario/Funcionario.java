package br.com.domain.model.funcionario;

import java.time.LocalDate;

import br.com.domain.model.usuario.Usuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode(of = "id")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String rg;
	
	private LocalDate dataNascimento;
	@JoinColumn(name = "id_usuario")
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	private boolean ativo;
	
	public Funcionario(FuncionarioDadosCadastro dados) {
		this.ativo = true;
		this.nome = dados.getNome();
		this.cpf = dados.getCpf();
		this.rg = dados.getRg();
		this.dataNascimento = dados.getDataNascimento();
		this.usuario = new Usuario(dados.getDadosUsuario());
		
	}
	
	public void atualizar(FuncionarioDadosAtualizacao dados) {
		
		if(dados.getNome() != null)
			this.nome = dados.getNome();
		
		if(dados.getCpf() != null)
			this.cpf = dados.getCpf();
		
		if(dados.getDataNascimento() != null)
			this.dataNascimento = dados.getDataNascimento();
		
		if (dados.getDadosUsuario() != null) {
			this.usuario.atualizar(dados.getDadosUsuario());
		}
	}
	
	public void desativar() {
		this.ativo = false;
	}
	
	

}
