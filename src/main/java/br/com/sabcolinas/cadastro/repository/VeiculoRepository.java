package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

	// Find

	public Veiculo findByTipo(String tipo);

	public Veiculo findByMarca(String marca);

	public Veiculo findByModelo(String modelo);

	public Veiculo findByCor(String cor);

	public Veiculo findByPlaca(String placa);

	public Veiculo findByObservacao(String observacao);

	public List<Veiculo> findAll();

	// Find Contains

	public Veiculo findByTipoContains(String tipo);

	public Veiculo findByMarcaContains(String marca);

	public Veiculo findByModeloContains(String modelo);

	public Veiculo findByCorContains(String cor);

	public Veiculo findByPlacaContains(String placa);

	public Veiculo findByObservacaoContains(String observacao);

	// Query

	@Query("select v from Veiculo v where v.tipo like %?1%")
	public List<Veiculo> buscaTipo(String tipo);

	@Query("select v from Veiculo v where v.marca like %?1%")
	public List<Veiculo> buscaMarca(String marca);

	@Query("select v from Veiculo v where v.modelo like %?1%")
	public List<Veiculo> buscaModelo(String modelo);

	@Query("select v from Veiculo v where v.cor like %?1%")
	public List<Veiculo> buscaCor(String cor);

	@Query("select v from Veiculo v where v.placa like %?1%")
	public List<Veiculo> buscaPlaca(String placa);

	@Query("select v from Veiculo v where v.observacao like %?1%")
	public List<Veiculo> buscaObservacao(String observacao);

}
