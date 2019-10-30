package br.com.sabcolinas.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prof_profissao")
public class Profissao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prof")
	//@JsonView({View.ProfissaoAvancado.class})
	private Long id;
	
	@Column(name = "prof_empresa")
	//@JsonView({View.ProfissaoBasico.class})
	private String empresa;
	
	@Column(name = "prof_cargo")
	//@JsonView({View.ProfissaoIntermediario.class})
	private String cargo;
	
	@Column(name = "prof_contato")
	//@JsonView({View.ProfissaoAvancado.class})
	private String contato;
	
	
	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
}
