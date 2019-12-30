package br.com.sabcolinas.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.sabcolinas.cadastro.view.View;

@Entity
@Table(name = "auto_autorizacao")
public class Autorizacao implements GrantedAuthority {

	private static final long serialVersionUID = 3078636239920155012L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_auto")
	@JsonView(View.Avancado.class)
	private Long id;

	@Column(name = "auto_nome", unique = true, length = 20, nullable = false)
	@JsonView({ View.Basico.class })
	private String nome;
	
	@Column(name = "auto_role", unique = true, length = 20, nullable = false)
	@JsonView({ View.Basico.class })
	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return this.role;
	}

	public void setAuthority(String authority) {
		this.role = authority;
	}


}
