package br.com.sabcolinas.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conj_conjuge")
public class Conjuge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conj")
	// @JsonView({View.ConjugeAvancado.class})
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pess_id", referencedColumnName = "id_pess")
	// @JsonView({View.ConjugeIntermediario.class})
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "prof_id", referencedColumnName = "id_prof")
	// @JsonView({View.ConjugeAvancado.class})
	private Trabalho trabalho;

	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

}
