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
@Table(name = "inqu_inquilino")
public class Inquilino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inqu")
	@JsonView({View.Avancado.class})
	private Long id;

	@Column(name = "inqu_especial", nullable = false)
	@JsonView({View.Basico.class})
	private boolean especial;

	@Column(name = "inqu_foto")
	@JsonView({View.Basico.class})
	private Blob foto;

	@ManyToOne
	@JoinColumn(name = "pess_id", nullable = false)
	@JsonView({View.Avancado.class})
	private Pessoa pessoa;

	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
