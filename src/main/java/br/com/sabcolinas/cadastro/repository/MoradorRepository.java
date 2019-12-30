package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Morador;

public interface MoradorRepository extends CrudRepository<Morador, Long> {

	public Morador findByParentesco(String parentesco);

	public List<Morador> findAll();

	public List<Morador> findByParentescoContains(String parentesco);

}
