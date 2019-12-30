package br.com.sabcolinas.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.sabcolinas.cadastro.view.View;

@Entity
@Table(name = "loca_locacao")
public class Locacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_loca")
	@JsonView({View.Avancado.class})
	private Long id;

	@Column(name = "loca_nome", length = 100, nullable = false)
	@JsonView({View.Basico.class})
	private String nome;

	@Column(name = "loca_telefone", length = 11, nullable = false)
	@JsonView({View.Basico.class})
	private String telefone;

	@Column(name = "loca_data_inicio", length = 10, nullable = false)
	@JsonView({View.Basico.class})
	private String dataInicio;

	@Column(name = "loca_data_termino", length = 10, nullable = false)
	@JsonView({View.Basico.class})
	private String dataTermino;

	// GETTERS E SETTERS

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

}
