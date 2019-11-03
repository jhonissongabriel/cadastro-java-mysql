package br.com.sabcolinas.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "veic_veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_veic")
	//@JsonView({View.VeiculoAvancado.class})
	private Long id;
	
	@Column(name = "veic_tipo", length = 50, nullable = false)
	//@JsonView({View.VeiculoBasico.class})
	private String tipo;
	
	@Column(name = "veic_marca", length = 50, nullable = false)
	//@JsonView({View.VeiculoBasico.class})
	private String marca;
	
	@Column(name = "veic_modelo", length = 50, nullable = false)
	//@JsonView({View.VeiculoBasico.class})
	private String modelo;
	
	@Column(name = "veic_cor", length = 50, nullable = false)
	//@JsonView({View.VeiculoBasico.class})
	private String cor;
	
	@Column(name = "veic_placa", length = 7, unique = true, nullable = false)
	//@JsonView({View.VeiculoIntermediario.class})
	private String placa;
	
	@Column(name = "veic_obs", length = 200)
	//@JsonView({View.VeiculoBasico.class})
	private String observacao;
	
	
	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	

}
