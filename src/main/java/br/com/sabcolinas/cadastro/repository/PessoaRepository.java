package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	// Find

	public Pessoa findByNome(String nome);

	public Pessoa findByDataNasc(String dataNasc);

	public Pessoa findByCpf(String cpf);

	public Pessoa findByRg(String rg);

	public List<Pessoa> findAll();

	public List<Pessoa> findByNomeContains(String nome);

	public List<Pessoa> findByCpfContains(String cpf);

	public List<Pessoa> findByRgContains(String rg);

	public List<Pessoa> findByDataNascContains(String dataNasc);

}
