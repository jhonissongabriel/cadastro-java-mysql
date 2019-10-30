package br.com.sabcolinas.cadastro.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "conj_conjuge")
public class Conjuge {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_conj")
	//@JsonView({View.ConjugeAvancado.class})
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pess_id", referencedColumnName = "id_pess")
	//@JsonView({View.ConjugeIntermediario.class})
	private Pessoa pessoa;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prof_id", referencedColumnName = "id_prof")
	//@JsonView({View.ConjugeAvancado.class})
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

	public Trabalho getProfissao() {
		return trabalho;
	}

	public void setProfissao(Trabalho trabalho) {
		this.trabalho = trabalho;
	}
	
	

}
