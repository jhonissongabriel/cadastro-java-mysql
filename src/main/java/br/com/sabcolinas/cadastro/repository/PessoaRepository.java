package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	// Find

	public Pessoa findByNome(String nome);

	public Pessoa findByDataNasc(String dataNasc);

	public Pessoa findByCpf(String cpf);

	public Pessoa findByRg(String rg);

	public Pessoa findByDocEmissor(String docEmissor);

	public List<Pessoa> findAll();

	// Find Contains

	public Pessoa findByNomeContains(String nome);

	public Pessoa findByCpfContains(String cpf);

	public Pessoa findByRgContains(String rg);

	public Pessoa findByDocEmissorContains(String docEmissor);

	// Query

	@Query("select p from Pessoa p where p.nome like %?1%")
	public List<Pessoa> buscaNome(String nome);

	@Query("select p from Pessoa p where p.cpf like %?1%")
	public List<Pessoa> buscaCpf(String cpf);

	@Query("select p from Pessoa p where p.rg like %?1%")
	public List<Pessoa> buscaRg(String rg);

	@Query("select p from Pessoa p where p.docEmissor like %?1%")
	public List<Pessoa> buscaDocEmissor(String docEmissor);

}
