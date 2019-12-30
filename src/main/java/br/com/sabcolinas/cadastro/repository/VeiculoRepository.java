package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

	public Veiculo findByMarca(String marca);

	public Veiculo findByCor(String cor);

	public Veiculo findByPlaca(String placa);

	public List<Veiculo> findAll();

	public List<Veiculo> findByMarcaContains(String marca);

	public List<Veiculo> findByCorContains(String cor);

	public List<Veiculo> findByPlacaContains(String placa);

}
