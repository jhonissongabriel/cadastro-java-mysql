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
@Table(name = "trab_trabalho")
public class Trabalho {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_trab")
	//@JsonView({View.TrabalhoAvancado.class})
	private Long id;
	
	@Column(name = "trab_empresa", length = 100, nullable = false)
	//@JsonView({View.TrabalhoBasico.class})
	private String empresa;
	
	@Column(name = "trab_profissao", length = 50, nullable = false)
	//@JsonView({View.TrabalhoIntermediario.class})
	private String profissao;
	
	@Column(name = "trab_telefone", length = 11)
	//@JsonView({View.TrabalhoAvancado.class})
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name = "ende_id")
	//@JsonView({View.TrabalhoAvancado.class})
	private Endereco endereco;
	
	
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

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
}
