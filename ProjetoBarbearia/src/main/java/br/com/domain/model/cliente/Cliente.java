package br.com.domain.model.cliente;

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

@Entity(name = "Cliente")
@Table(name = "cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
	
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

	public Cliente(ClienteDadosCadastro dados) {
		this.ativo = true;
		this.nome = dados.getNome();
		this.cpf = dados.getCpf();
		this.rg = dados.getCpf();
		this.dataNascimento = dados.getDataNascimento();
		this.usuario = new Usuario(dados.getDadosUsuario());
	}

	public void atualizarInformacoes(ClienteDadosAtualizacao dados) {
		
		if(dados.getNome() != null)
			this.nome = dados.getNome();
		
		if(dados.getDataNascimento() != null)
			this.dataNascimento = dados.getDataNascimento();
		
		if (dados.getDadosUsuario() != null) {
			this.usuario.atualizar(dados.getDadosUsuario());
		}
	}
}
