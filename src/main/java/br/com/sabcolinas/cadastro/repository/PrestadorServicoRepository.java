package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.PrestadorServico;

public interface PrestadorServicoRepository extends CrudRepository<PrestadorServico, Long> {

	// Find

	public List<PrestadorServico> findAll();

}
