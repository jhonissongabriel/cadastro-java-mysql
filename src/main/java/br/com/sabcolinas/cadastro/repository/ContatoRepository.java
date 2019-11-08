package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Long> {

	// Find

	public Contato findByTelefone1(String telefone1);

	public Contato findByTelefone2(String telefone2);

	public Contato findByEmail(String email);

	public List<Contato> findAll();

	// Find Contains

	public List<Contato> findByTelefone1Contains(String telefone1);

	public List<Contato> findByTelefone2Contains(String telefone2);

	public List<Contato> findByEmailContains(String email);

	// Query

	@Query("select c from Contato c where c.telefone1 like %?1%")
	public List<Contato> buscaTelefone1(String telefone1);

	@Query("select c from Contato c where c.telefone2 like %?1%")
	public List<Contato> buscaTelefone2(String telefone2);

	@Query("select c from Contato c where c.email like %?1%")
	public List<Contato> buscaEmail(String email);
	
	@Query("select c from Contato c where c.telefone1 = %?1% and c.telefone2 = %?2% and c.email = %?3%")
	public Contato buscaTelefone1Telefone2Email(String telefone1, String telefone2, String email);

}
