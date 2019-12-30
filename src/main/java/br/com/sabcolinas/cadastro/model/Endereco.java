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
@Table(name = "ende_endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ende")
	@JsonView({View.Avancado.class})
	private Long id;

	@Column(name = "ende_rua", length = 100, nullable = false)
	@JsonView({View.Basico.class})
	private String rua;

	@Column(name = "ende_numero", nullable = false)
	@JsonView({View.Basico.class})
	private int numero;

	@Column(name = "ende_codigo", length = 6, unique = true)
	@JsonView({View.Basico.class})
	private String codigo;

	@Column(name = "ende_cep", length = 9, nullable = false)
	@JsonView({View.Basico.class})
	private String cep;

	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
