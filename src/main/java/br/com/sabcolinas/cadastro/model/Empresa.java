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
@Table(name = "empr_empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_empr")
	//@JsonView({View.EmpresaAvancado.class})
	private Long id;
	
	@Column(name = "empr_cnpj", length = 14, nullable = false)
	//@JsonView({View.EmpresaIntermediario.class})
	private String cnpj;
	
	@Column(name = "empr_razao", length = 100, nullable = false)
	//@JsonView({View.EmpresaIntermediario.class})
	private String razaoSocial;
	
	@Column(name = "empr_fantasia", length = 100)
	//@JsonView({View.EmpresaIntermediario.class})
	private String nomeFantasia;
	
	@ManyToOne
	@JoinColumn(name = "ende_id")
	//@JsonView({View.EmpresaoAvancado.class})
	private Endereco endereco;

	
	// GETTERS E SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
