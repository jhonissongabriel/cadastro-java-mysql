package br.com.sabcolinas.cadastro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Dependente;

public interface DependenteRepository extends CrudRepository<Dependente, Long> {

	// Find
	public  Optional<Dependente> findById(Long id);

	public Dependente findByParentesco(String parentesco);

	public List<Dependente> findAll();

	// Find Contains

	public Dependente findByParentescoContains(String parentesco);

	// Query

	@Query("select d from Dependente d where d.parentesco like %?1%")
	public List<Dependente> buscaParentesco(String parentesco);
}
