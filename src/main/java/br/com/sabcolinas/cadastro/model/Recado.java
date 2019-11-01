package br.com.sabcolinas.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reca_recado")
public class Recado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_reca")
	//@JsonView({View.RecadoAvancado.class})
	private Long id;
	
	@Column(name = "reca_nome", length = 50, nullable = false)
	//@JsonView({View.RecadoBasico.class})
	private String nome;
	
	@Column(name = "reca_parentesco", length = 50, nullable = false)
	//@JsonView({View.RecadoBasico.class})
	private String parentesco;
	
	@Column(name = "reca_parentesco", length = 11, nullable = false)
	//@JsonView({View.RecadoBasico.class})
	private String telefone;
	
	
	//GETTERS E SETTERS

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

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
