package br.com.sabcolinas.cadastro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aces_acesso")
public class Acesso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_aces")
	//@JsonView({View.AcessoAvancado.class})
	private Long id;
	
	@Column(name = "aces_data_inicio", nullable = false)
	//@JsonView({View.AcessoBasico.class})
	private Date dataInicio;
	
	@Column(name = "aces_data_termino", nullable = false)
	//@JsonView({View.AcessoBasico.class})
	private Date dataTermino;
	
	
	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	

}
