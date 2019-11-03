package br.com.sabcolinas.cadastro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pess_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_pess")
	//@JsonView({View.PessoaAvancado.class})
	private Long id;

	@Column(name = "pess_nome", length = 100, nullable = false)
	//@JsonView({View.PessoaBasico.class})
	private String nome;
	
	@Column(name = "pess_data_nasc", nullable = false)
	//@JsonView({View.PessoaIntermediario.class})
	private Date dataNasc;
	
	@Column(name = "pess_cpf", length = 11, unique = true, nullable = false)
	//@JsonView({View.PessoaIntermediario.class})
	private String cpf;
	
	@Column(name = "pess_rg", length = 10, unique = true, nullable = false)
	//@JsonView({View.PessoaIntermediario.class})
	private String rg;
	
	@Column(name = "pess_emissor", length = 50, nullable = false)
	//@JsonView({View.PessoaIntermediario.class})
	private String docEmissor;
	
	@ManyToOne
	@JoinColumn(name = "aces_id")
	//@JsonView({View.PessoaAvancado.class})
	private Acesso acesso;

	
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

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
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

	public String getDocEmissor() {
		return docEmissor;
	}

	public void setDocEmissor(String docEmissor) {
		this.docEmissor = docEmissor;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

}
