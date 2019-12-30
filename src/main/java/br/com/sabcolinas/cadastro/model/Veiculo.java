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
@Table(name = "veic_veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veic")
	@JsonView({ View.Avancado.class })
	private Long id;

	@Column(name = "veic_marca", length = 50, nullable = false)
	@JsonView({ View.Basico.class })
	private String marca;

	@Column(name = "veic_cor", length = 50, nullable = false)
	@JsonView({ View.Basico.class })
	private String cor;

	@Column(name = "veic_placa", length = 7, unique = true, nullable = false)
	@JsonView({ View.Intermediario.class })
	private String placa;

	// GETTERS E SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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

}
