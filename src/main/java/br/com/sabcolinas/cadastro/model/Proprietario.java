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

@Entity
@Table(name = "prop_propietario")
public class Proprietario {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prop")
	//@JsonView({View.ProprietarioAvancado.class})
	private Long id;
	
	@Column(name = "prop_foto")
	//@JsonView({View.ProprietarioIntermediario.class})
	private Blob foto;
	
	@Column(name = "prop_info", length = 400)
	//@JsonView({View.ProprietarioBasico.class})
	private String informacoes;
	
	@ManyToOne
	@JoinColumn(name = "pess_id")
	//@JsonView({View.ProprietarioAvancado.class})
	private Pessoa pessoa;

	// GETTERS E SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

}
