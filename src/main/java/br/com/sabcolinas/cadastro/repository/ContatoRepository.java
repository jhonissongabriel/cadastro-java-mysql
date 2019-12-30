package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Long> {

	public Contato findByTelefone1(String telefone1);

	public Contato findByTelefone2(String telefone2);

	public Contato findByEmail(String email);

	public List<Contato> findAll();

	public List<Contato> findByTelefone1Contains(String telefone1);

	public List<Contato> findByTelefone2Contains(String telefone2);

	public List<Contato> findByEmailContains(String email);

}
