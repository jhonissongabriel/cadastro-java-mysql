package br.com.sabcolinas.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ende_endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_ende")
	//@JsonView({View.EnderecoAvancado.class})
	private Long id;

	@Column(name = "ende_logradouro", length = 100, nullable = false)
	//@JsonView({View.EnderecoIntermediario.class})
	private String logradouro;
	
	@Column(name = "ende_numero", nullable = false)
	//@JsonView({View.EnderecoIntermediario.class})
	private int numero;
	
	@Column(name = "ende_codigo", length = 6, unique = true)
	//@JsonView({View.EnderecoIntermediario.class})
	private String codigo;
	
	@Column(name = "ende_complemento", length = 100)
	//@JsonView({View.EnderecoIntermediario.class})
	private String complemento;
	
	@Column(name = "ende_bairro", length = 50, nullable = false)
	//@JsonView({View.EnderecoBasico.class})
	private String bairro;
	
	@Column(name = "ende_cep", length = 8, nullable = false)
	//@JsonView({View.EnderecoIntermediario.class})
	private String cep;
	
	@Column(name = "ende_cidade", length = 50, nullable = false)
	//@JsonView({View.EnderecoBasico.class})
	private String cidade;
	
	@Column(name = "ende_estado", length = 50, nullable = false)
	//@JsonView({View.EnderecoBasico.class})
	private String estado;
	
	
	// GETTERS E SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
