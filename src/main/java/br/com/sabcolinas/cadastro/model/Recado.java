package br.com.sabcolinas.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.sabcolinas.cadastro.view.View;

@Entity
@Table(name = "reca_recado")
public class Recado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reca")
	@JsonView({View.Avancado.class})
	private Long id;

	@Column(name = "reca_nome", length = 50, nullable = false)
	@JsonView({View.Basico.class})
	private String nome;

	@Column(name = "reca_telefone_1", length = 11, nullable = false)
	@JsonView({View.Basico.class})
	private String telefone1;

	@Column(name = "reca_telefone_2", length = 11)
	@JsonView({View.Basico.class})
	private String telefone2;

	// GETTERS E SETTERS
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

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

}
