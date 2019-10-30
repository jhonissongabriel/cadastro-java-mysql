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
@Table(name = "depe_dependente")
public class Dependente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_depe")
	//@JsonView({View.DependenteAvancado.class})
	private Long id;
	
	@Column(name = "depe_parentesco", length = 50)
	//@JsonView({View.DependenteIntermediario.class})
	private String parentesco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pess_id", referencedColumnName = "id_pess")
	//@JsonView({View.DependenteIntermediario.class})
	private Pessoa pessoa;

	//GETTERS E SETTERS
	
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
