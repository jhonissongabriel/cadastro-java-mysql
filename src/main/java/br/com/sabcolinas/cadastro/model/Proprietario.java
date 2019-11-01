package br.com.sabcolinas.cadastro.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prop_propietario")
public class Proprietario {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prop")
	//@JsonView({View.ProprietarioAvancado.class})
	private Long id;
	
	@Column(name = "prop_foto")
	//@JsonView({View.ProprietarioIntermediario.class})
	private Blob foto;
	
	@Column(name = "prop_info", length = 400)
	//@JsonView({View.ProprietarioBasico.class})
	private String informacoes;
	
	@ManyToOne
	@JoinColumn(name = "pess_id")
	//@JsonView({View.ProprietarioAvancado.class})
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "trab_id")
	//@JsonView({View.ProprietarioAvancado.class})
	private Trabalho trabalho;
	
	@ManyToOne
	@JoinColumn(name = "conj_id")
	//@JsonView({View.ProprietarioAvancado.class})
	private Conjuge conjuge;
	
	@ManyToOne
	@JoinColumn(name = "depe_id")
	//@JsonView({View.ProprietarioAvancado.class})
	private Dependente dependente;
	
	@ManyToOne
	@JoinColumn(name = "func_id")
	//@JsonView({View.ProprietarioAvancado.class})
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "ende_id")
	//@JsonView({View.ProprietarioAvancado.class})
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "cont_id")
	//@JsonView({View.ProprietarioAvancado.class})
	private Contato contato;
	
	@ManyToOne
	@JoinColumn(name = "reca_id")
	//@JsonView({View.ProprietarioAvancado.class})
	private Recado recado;
	
	@ManyToOne
	@JoinColumn(name = "veic_id")
	//@JsonView({View.ProprietarioAvancado.class})
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn(name = "anim_id")
	//@JsonView({View.ProprietarioAvancado.class})
	private Animal animal;

	// GETTERS E SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

	public Conjuge getConjuge() {
		return conjuge;
	}

	public void setConjuge(Conjuge conjuge) {
		this.conjuge = conjuge;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Recado getRecado() {
		return recado;
	}

	public void setRecado(Recado recado) {
		this.recado = recado;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	

}
