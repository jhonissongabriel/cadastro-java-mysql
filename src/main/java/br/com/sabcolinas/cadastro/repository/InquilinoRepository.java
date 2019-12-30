package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Inquilino;

public interface InquilinoRepository extends CrudRepository<Inquilino, Long> {

	public List<Inquilino> findAll();

	public Inquilino findByEspecial(boolean especial);

	public List<Inquilino> findByEspecialContains(boolean especial);

}
