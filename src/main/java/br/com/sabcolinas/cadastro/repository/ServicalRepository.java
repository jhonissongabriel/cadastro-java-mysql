package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Servical;

public interface ServicalRepository extends CrudRepository<Servical, Long> {

	// Find

	public List<Servical> findAll();

}
