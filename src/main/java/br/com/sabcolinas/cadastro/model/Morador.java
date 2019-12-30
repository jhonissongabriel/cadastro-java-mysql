package br.com.sabcolinas.cadastro.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.sabcolinas.cadastro.view.View;

@Entity
@Table(name = "mora_morador")
public class Morador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mora")
	@JsonView({View.Avancado.class})
	private Long id;

	@Column(name = "mora_parentesco", length = 50, nullable = false)
	@JsonView({View.Basico.class})
	private String parentesco;

	@Column(name = "mora_foto")
	@JsonView({View.Basico.class})
	private Blob foto;

	@ManyToOne
	@JoinColumn(name = "pess_id", nullable = false)
	@JsonView({ View.Avancado.class })
	private Pessoa pessoa;

	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
