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
@Table(name = "pess_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pess")
	@JsonView({View.Avancado.class})
	private Long id;

	@Column(name = "pess_nome", length = 100, nullable = false)
	@JsonView({View.Basico.class})
	private String nome;

	@Column(name = "pess_data_nasc", length = 10, nullable = false)
	@JsonView({View.Basico.class})
	private String dataNasc;

	@Column(name = "pess_cpf", length = 11, unique = true, nullable = false)
	@JsonView({View.Basico.class})
	private String cpf;

	@Column(name = "pess_rg", length = 10, unique = true, nullable = false)
	@JsonView({View.Basico.class})
	private String rg;

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

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}
