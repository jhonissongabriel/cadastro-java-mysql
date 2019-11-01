package br.com.sabcolinas.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anim_animal")
public class Animal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_anim")
	//@JsonView({View.AnimalAvancado.class})
	private Long id;
	
	@Column(name = "anim_tipo", length = 50)
	//@JsonView({View.AnimalBasico.class})
	private String tipo;
	
	@Column(name = "anim_raca", length = 50)
	//@JsonView({View.AnimalBasico.class})
	private String raca;
	
	@Column(name = "anim_nome", length = 50)
	//@JsonView({View.AnimalBasico.class})
	private String nome;
	
	@Column(name = "anim_registro", length = 50)
	//@JsonView({View.AnimalBasico.class})
	private String registro;
	
	@Column(name = "anim_obs", length = 200)
	//@JsonView({View.AnimalBasico.class})
	private String obs;
	
	
	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
