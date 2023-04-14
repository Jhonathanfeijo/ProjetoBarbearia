package br.com.domain.model.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	private String login;
	@NotEmpty
	private String senha;
	
	public Usuario(DadosCadastroUsuario dadosUsuario) {
		this.id = null;
		this.login = dadosUsuario.getLogin();
		this.senha = dadosUsuario.getSenha();
	}

	public void atualizar(DadosAtualizacaoUsuario usuario) {
		
		if (usuario.getLogin() != null) {
			this.login = usuario.getLogin();
		}
		if (usuario.getSenha() != null) {
			this.senha = usuario.getSenha();
		}
	}

}