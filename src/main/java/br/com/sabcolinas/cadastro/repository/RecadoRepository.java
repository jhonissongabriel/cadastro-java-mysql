package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Recado;

public interface RecadoRepository extends CrudRepository<Recado, Long> {

	// Find

	public Recado findByNome(String nome);

	public Recado findByParentesco(String parentesco);

	public Recado findByTelefone(String telefone);

	public List<Recado> findAll();

	// Find Contains

	public List<Recado> findByNomeContains(String nome);

	public List<Recado> findByParentescoContains(String parentesco);

	public List<Recado> findByTelefoneContains(String telefone);

	// Query

	@Query("select r from Recado r where r.nome like %?1%")
	public List<Recado> buscaNome(String nome);

	@Query("select r from Recado r where r.parentesco like %?1%")
	public List<Recado> buscaParentesco(String parentesco);

	@Query("select r from Recado r where r.telefone like %?1%")
	public List<Recado> buscaTelefone(String telefone);
	
	@Query("select r from Recado r where r.nome = %?1% and r.parentesco = %?2% and r.telefone = %?3%")
	public Recado buscaRecado(String nome, String parentesco, String telefone);

}
