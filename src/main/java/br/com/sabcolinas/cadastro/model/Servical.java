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
@Table(name = "serv_servical")
public class Servical {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_serv")
	//@JsonView({View.ServicalAvancado.class})
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "pess_id")
	//@JsonView({View.ServicalAvancado.class})
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "func_id")
	//@JsonView({View.ServicalAvancado.class})
	private Funcionario funcionario;
	
	
	//GETTERS E SETTERS

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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}
