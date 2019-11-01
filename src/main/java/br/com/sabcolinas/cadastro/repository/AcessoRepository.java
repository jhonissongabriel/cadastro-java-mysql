package br.com.sabcolinas.cadastro.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Acesso;

public interface AcessoRepository extends CrudRepository<Acesso, Long> {

	// Find

	public Acesso findByDataInicio(Date dataInicio);

	public Acesso findByDataTermino(Date dataTermino);

	public List<Acesso> findAll();

	// Query

	@Query("select a from Acesso a where a.dataInicio like %?1%")
	public List<Acesso> buscaDataInicio(Date dataInicio);

	@Query("select a from Acesso a where a.dataTermino like %?1%")
	public List<Acesso> buscaDataTermino(Date dataTermino);

}
