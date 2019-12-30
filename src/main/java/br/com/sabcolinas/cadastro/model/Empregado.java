package br.com.sabcolinas.cadastro.model;

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
@Table(name = "empr_empregado")
public class Empregado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empr")
	@JsonView({View.Avancado.class})
	private Long id;

	@Column(name = "empr_dia_trab", length = 50, nullable = false)
	@JsonView({View.Basico.class})
	private String diaTrabalho;

	@Column(name = "empr_hora_trab", length = 20, nullable = false)
	@JsonView({View.Basico.class})
	private String horarioTrabalho;

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

	public String getDiaTrabalho() {
		return diaTrabalho;
	}

	public void setDiaTrabalho(String diaTrabalho) {
		this.diaTrabalho = diaTrabalho;
	}

	public String getHorarioTrabalho() {
		return horarioTrabalho;
	}

	public void setHorarioTrabalho(String horarioTrabalho) {
		this.horarioTrabalho = horarioTrabalho;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
