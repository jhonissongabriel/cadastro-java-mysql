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
@Table(name = "prse_prestador_servico")
public class PrestadorServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prse")
	// @JsonView({View.PrestadorServicoAvancado.class})
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pess_id")
	// @JsonView({View.PrestadorServicoAvancado.class})
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "empr_id")
	// @JsonView({View.PrestadorServicoAvancado.class})
	private Empresa empresa;

	// GETTERS E SETTERS

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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
