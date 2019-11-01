package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Conjuge;

public interface ConjugeRepository extends CrudRepository<Conjuge, Long>{
	
	// Find
	
	public List<Conjuge> findAll();	

}
