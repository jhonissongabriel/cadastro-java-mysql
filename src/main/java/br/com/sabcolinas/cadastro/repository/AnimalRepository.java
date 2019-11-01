package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long> {

	// Find

	public Animal findByTipo(String tipo);

	public Animal findByRaca(String raca);

	public Animal findByNome(String nome);

	public Animal findByRegistro(String registro);

	public Animal findByObservacao(String observacao);

	public List<Animal> findAll();

	// Find Contains

	public Animal findByTipoContains(String tipo);

	public Animal findByRacaContains(String raca);

	public Animal findByNomeContains(String nome);

	public Animal findByRegistroContains(String registro);

	public Animal findByObservacaoContains(String observacao);

	// Query

	@Query("select a from Animal a where a.tipo like %?1%")
	public List<Animal> buscaTipo(String tipo);

	@Query("select a from Animal a where a.raca like %?1%")
	public List<Animal> buscaRaca(String raca);

	@Query("select a from Animal a where a.nome like %?1%")
	public List<Animal> buscaNome(String nome);

	@Query("select a from Animal a where a.registro like %?1%")
	public List<Animal> buscaRegistro(String registro);

	@Query("select a from Animal a where a.observacao like %?1%")
	public List<Animal> buscaObservacao(String observacao);

}
