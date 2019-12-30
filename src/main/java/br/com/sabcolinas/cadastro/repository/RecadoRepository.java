package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Recado;

public interface RecadoRepository extends CrudRepository<Recado, Long> {

	public Recado findByTelefone1(String telefone1);

	public Recado findByTelefone2(String telefone2);

	public Recado findByNome(String nome);

	public List<Recado> findAll();

	public List<Recado> findByTelefone1Contains(String telefone1);

	public List<Recado> findByTelefone2Contains(String telefone2);

	public List<Recado> findByNomeContains(String nome);

}
